package Canvas;

import Canvas.Commands.CanvasCommandWrapper;
import Canvas.Commands.CommandWrapper;
import Canvas.Commands.LineCommandWrapper;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class CommandParserTests {

    @Test
    public void parse_canvas_command(){

        CommandParser cmdParser = new CommandParser();
        Optional<CommandWrapper> cmd = cmdParser.parseCommand("C 2 2");
        Assert.assertTrue(cmd.get() instanceof CanvasCommandWrapper);
    }

    @Test
    public void parse_invalid_command(){

        CommandParser cmdParser = new CommandParser();
        Optional<CommandWrapper> cmd = cmdParser.parseCommand("D 2 2");
        Assert.assertFalse(cmd.isPresent());
    }

    @Test
    public void parse_line_command(){
        CommandParser cmdParser = new CommandParser();
        Optional<CommandWrapper> cmd = cmdParser.parseCommand("L 1 1 1 2");
        Assert.assertTrue(cmd.get() instanceof LineCommandWrapper);
    }
}
