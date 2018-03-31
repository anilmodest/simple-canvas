package Canvas.Commands;

import Canvas.Commands.CanvasCommand;
import Canvas.Commands.LineCommand;
import org.junit.Assert;
import org.junit.Test;

public class LineCommandTests {

    @Test
    public void validate_line_command_small_caps(){
        LineCommand cmd = new LineCommand();
        Boolean isValid = cmd.isValid("l 2 2 4 2");
        Assert.assertTrue(isValid);
    }

    @Test
    public void validate_line_command_caps(){
        LineCommand cmd = new LineCommand();
        Boolean isValid = cmd.isValid("L 2 2 4 2");
        Assert.assertTrue(isValid);
    }

    @Test
    public void should_not_validate_wrong_command(){
        LineCommand cmd = new LineCommand();
        Boolean isValid = cmd.isValid("W 2 2 4 2");
        Assert.assertFalse(isValid);
    }
}
