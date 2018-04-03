package Canvas.Commands;

import org.junit.Assert;
import org.junit.Test;

public class CanvasShapeCommandTests {

    @Test
    public void validate_canvas_command_small_caps(){
        CanvasCommandWrapper cmd = new CanvasCommandWrapper();
        Boolean isValid = cmd.isValid("c 2 2");
        Assert.assertTrue(isValid);
    }

    @Test
    public void validate_canvas_command_caps(){
        CanvasCommandWrapper cmd = new CanvasCommandWrapper();
        Boolean isValid = cmd.isValid("C 2 2");
        Assert.assertTrue(isValid);
    }

    @Test
    public void should_not_validate_wrong_command(){
        CanvasCommandWrapper cmd = new CanvasCommandWrapper();
        Boolean isValid = cmd.isValid("D 2 2");
        Assert.assertFalse(isValid);
    }
}
