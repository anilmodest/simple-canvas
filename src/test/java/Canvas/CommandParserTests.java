package Canvas;

import Canvas.Commands.CanvasCommand;
import Canvas.Commands.ICommand;
import Canvas.Commands.LineCommand;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class CommandParserTests {

    @Test
    public void parse_canvas_command(){

        CommandParser cmdParser = new CommandParser();
        Optional<ICommand> cmd = cmdParser.parseCommand("C 2 2");
        Assert.assertTrue(cmd.get() instanceof CanvasCommand);
    }

    @Test
    public void parse_invalid_command(){

        CommandParser cmdParser = new CommandParser();
        Optional<ICommand> cmd = cmdParser.parseCommand("D 2 2");
        Assert.assertFalse(cmd.isPresent());
    }

    @Test
    public void parse_line_command(){
        CommandParser cmdParser = new CommandParser();
        Optional<ICommand> cmd = cmdParser.parseCommand("L 1 1 1 2");
        Assert.assertTrue(cmd.get() instanceof LineCommand);
    }
}
