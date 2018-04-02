package Canvas.Commands;

import Canvas.Shapes.BucketFill;
import Canvas.Shapes.IShape;

import java.util.regex.Matcher;

public class BucketFillCommand implements ICommand {
    private Integer X1;
    private Integer Y1;
    private char drawingChar;

    @Override
    public Boolean isValid(String cmd) {
        Matcher m = SupportedCommands.BUCKET_FILL_COMMAND.matcher(cmd);
        if (m.matches()) {
            this.X1 = Integer.parseInt(m.group("X1"));
            this.Y1 = Integer.parseInt(m.group("Y1"));
            this.drawingChar =  m.group("C").charAt(0);
            return true;
        }

        return false;
    }

    @Override
    public IShape getShape() {
        return new BucketFill(this.X1, this.Y1, this.drawingChar);
    }
}
