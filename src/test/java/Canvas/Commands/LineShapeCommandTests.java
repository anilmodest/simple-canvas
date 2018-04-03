package Canvas.Commands;

import org.junit.Assert;
import org.junit.Test;

public class LineShapeCommandTests {

    @Test
    public void validate_line_command_small_caps(){
        LineCommandWrapper cmd = new LineCommandWrapper();
        Boolean isValid = cmd.isValid("l 2 2 4 2");
        Assert.assertTrue(isValid);
    }

    @Test
    public void validate_line_command_caps(){
        LineCommandWrapper cmd = new LineCommandWrapper();
        Boolean isValid = cmd.isValid("L 2 2 4 2");
        Assert.assertTrue(isValid);
    }

    @Test
    public void should_not_validate_wrong_command(){
        LineCommandWrapper cmd = new LineCommandWrapper();
        Boolean isValid = cmd.isValid("W 2 2 4 2");
        Assert.assertFalse(isValid);
    }
}
