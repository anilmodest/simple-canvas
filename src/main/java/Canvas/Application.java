package Canvas;

import Canvas.Commands.HelpCommandWrapper;
import Canvas.Commands.CommandWrapper;
import Canvas.Commands.QuitCommandWrapper;
import Canvas.Exceptions.ExceptionMessages;
import Canvas.Renderer.TextRenderer;
import Canvas.Renderer.SystemConsole;

import java.util.Optional;
import java.util.Scanner;

public class Application {

    public static void main(String[] args){
        System.out.println("Started Simple CanvasShape!");
        helpText();
        runUserIO();
    }

    private static void runUserIO(){
        CommandParser cmdParser = new CommandParser();
        CommandManager cmdManager = new CommandManager(new TextRenderer(new SystemConsole()));
        try(Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.printf("Please enter command: ");
                String cmdText = scanner.nextLine().trim();
                Optional<CommandWrapper> optionalCommand = cmdParser.parseCommand(cmdText);
                if (optionalCommand.isPresent()) {
                    CommandWrapper cmd = optionalCommand.get();

                    if (cmd instanceof QuitCommandWrapper) {
                        System.exit(0);
                    } else if (cmd instanceof HelpCommandWrapper) {
                        helpText();
                    } else {

                        try {
                            String errorMessage = cmdManager.execute(cmd);
                            if(errorMessage.length() > 0) {
                                System.out.println(errorMessage);
                                continue;
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
                else {
                    System.out.println(ExceptionMessages.INVALID_COMMAND);
                }

            }


        }

    }

    private static void helpText() {
        System.out.println("**********************CanvasShape***********************");
        System.out.println("Supported Commands:");
        System.out.println("Draw CanvasShape: C|c l h");
        System.out.println("Draw CanvasShape: L|l x1 y1 x2 y2");
        System.out.println("Draw CanvasShape: R|r x1 y1 x2 y2");
        System.out.println("Draw CanvasShape: B|b x y");
        System.out.println("Quit: Q|q");
        System.out.println("Help : H|h");
    }
}
