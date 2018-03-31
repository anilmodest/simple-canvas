package Canvas;

import Canvas.Commands.CanvasCommand;
import Canvas.Commands.ICommand;
import Canvas.Commands.LineCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CommandParser {

    private List<ICommand> supportedCommands;

    public CommandParser(){
        this.supportedCommands = new ArrayList<>();
        this.supportedCommands.add(new CanvasCommand());
        this.supportedCommands.add(new LineCommand());
    }
    public Optional<ICommand> parseCommand(String cmdText) {
        return this.supportedCommands.stream().filter(cmd -> cmd.isValid(cmdText)).findFirst();
    }
}
