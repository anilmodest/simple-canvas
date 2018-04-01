package Canvas.Commands;

import Canvas.Shapes.IShape;
import Canvas.Shapes.Line;
import Canvas.Shapes.Rectangle;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RectangleCommand implements ICommand {
    private Pattern _lineRegPattern= Pattern.compile("^[R|r]\\s(?<X1>\\d+)\\s(?<Y1>\\d+)\\s(?<X2>\\d+)\\s(?<Y2>\\d+)$");
    private Integer X1;
    private Integer Y1;
    private Integer X2;
    private Integer Y2;
    private IShape rectangle;


    @Override
    public Boolean isValid(String cmd) {
        Matcher m = _lineRegPattern.matcher(cmd);
        if (m.matches()) {
            this.X1 = Integer.parseInt(m.group("X1"));
            this.Y1 = Integer.parseInt(m.group("Y1"));
            this.X2 = Integer.parseInt(m.group("X2"));
            this.Y2 = Integer.parseInt(m.group("Y2"));
            return true;
        }

        return false;
    }

    @Override
    public IShape getShape() {
        return new Rectangle(this.X1, this.Y1, this.X2, this.Y2);
    }
}
