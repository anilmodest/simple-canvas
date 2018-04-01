package Canvas;

import Canvas.Commands.HelpCommand;
import Canvas.Commands.ICommand;
import Canvas.Commands.QuitCommand;
import Canvas.Exceptions.ExceptionMessages;
import Canvas.Renderer.Renderer;
import Canvas.Renderer.SystemConsole;

import java.util.Optional;
import java.util.Scanner;

public class Application {

    public static void main(String[] args){
        System.out.println("Started Simple Canvas!");
        helpText();
        runUserIO();
    }

    private static void runUserIO(){
        CommandParser cmdParser = new CommandParser();
        CommandManager cmdManager = new CommandManager(new Renderer(new SystemConsole()));
        try(Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.printf("Please enter command: ");
                String cmdText = scanner.nextLine().trim();
                Optional<ICommand> optionalCommand = cmdParser.parseCommand(cmdText);
                if (optionalCommand.isPresent()) {
                    ICommand cmd = optionalCommand.get();

                    if (cmd instanceof QuitCommand) {
                        System.exit(0);
                    } else if (cmd instanceof HelpCommand) {
                        helpText();
                    } else {

                        try {
                            cmdManager.execute(cmd);
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
        System.out.println("**********************Canvas***********************");
        System.out.println("Supported Commands:");
        System.out.println("Draw Canvas: C|c l h");
        System.out.println("Draw Canvas: L|l x1 y1 x2 y2");
        System.out.println("Draw Canvas: R|r x1 y1 x2 y2");
        System.out.println("Draw Canvas: B|b x y");
        System.out.println("Quit: Q|q");
        System.out.println("Help : H|h");
    }
}
