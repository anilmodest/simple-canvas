package Canvas.Commands;

import Canvas.Shapes.BucketFill;
import Canvas.Shapes.IShape;
import Canvas.Shapes.Line;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BucketFillCommand implements ICommand {
    private Pattern bucketFillRegPattern= Pattern.compile("^[B|b]\\s(?<X1>\\d+)\\s(?<Y1>\\d+)$");
    private Integer X1;
    private Integer Y1;

    @Override
    public Boolean isValid(String cmd) {
        Matcher m = this.bucketFillRegPattern.matcher(cmd);
        if (m.matches()) {
            this.X1 = Integer.parseInt(m.group("X1"));
            this.Y1 = Integer.parseInt(m.group("Y1"));
            return true;
        }

        return false;
    }

    @Override
    public IShape getShape() {
        return new BucketFill(this.X1, this.Y1);
    }
}
