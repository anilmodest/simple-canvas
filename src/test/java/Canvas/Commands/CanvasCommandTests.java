package Canvas.Commands;

import Canvas.Commands.CanvasCommand;
import org.junit.Assert;
import org.junit.Test;

public class CanvasCommandTests {

    @Test
    public void validate_canvas_command_small_caps(){
        CanvasCommand cmd = new CanvasCommand();
        Boolean isValid = cmd.isValid("c 2 2");
        Assert.assertTrue(isValid);
    }

    @Test
    public void validate_canvas_command_caps(){
        CanvasCommand cmd = new CanvasCommand();
        Boolean isValid = cmd.isValid("C 2 2");
        Assert.assertTrue(isValid);
    }

    @Test
    public void should_not_validate_wrong_command(){
        CanvasCommand cmd = new CanvasCommand();
        Boolean isValid = cmd.isValid("D 2 2");
        Assert.assertFalse(isValid);
    }
}
