package Canvas;

import Canvas.Commands.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CommandParser {

    private List<CommandWrapper> supportedCommands;

    public CommandParser(){

    }
    public Optional<CommandWrapper> parseCommand(String cmdText) {
        this.supportedCommands = new ArrayList<>();
        this.supportedCommands.add(new CanvasCommandWrapper());
        this.supportedCommands.add(new LineCommandWrapper());
        this.supportedCommands.add(new RectangleCommandWrapper());
        this.supportedCommands.add(new BucketFillCommandWrapper());
        this.supportedCommands.add(new QuitCommandWrapper());
        this.supportedCommands.add(new HelpCommandWrapper());
        this.supportedCommands.add(new RedoCommandWrapper());
        this.supportedCommands.add(new UndoCommandWrapper());

        return this.supportedCommands.stream().filter(cmd -> cmd.isValid(cmdText)).findFirst();
    }
}
