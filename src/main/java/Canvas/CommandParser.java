package Canvas;

import Canvas.Commands.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CommandParser {

    private List<ICommand> supportedCommands;

    public CommandParser(){

    }
    public Optional<ICommand> parseCommand(String cmdText) {
        this.supportedCommands = new ArrayList<>();
        this.supportedCommands.add(new CanvasCommand());
        this.supportedCommands.add(new LineCommand());
        this.supportedCommands.add(new RectangleCommand());
        this.supportedCommands.add(new BucketFillCommand());
        this.supportedCommands.add(new QuitCommand());
        this.supportedCommands.add(new HelpCommand());
        this.supportedCommands.add(new RedoCommand());
        this.supportedCommands.add(new UndoCommand());

        return this.supportedCommands.stream().filter(cmd -> cmd.isValid(cmdText)).findFirst();
    }
}
