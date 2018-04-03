package Canvas.Commands;

import Canvas.Shapes.LineShape;
import Canvas.Shapes.Shape;

import java.util.regex.Matcher;

public class LineCommandWrapper implements CommandWrapper {

    private Integer X1;
    private Integer Y1;
    private Integer X2;
    private Integer Y2;
    private Shape line;

    @Override
    public Boolean isValid(String cmd) {
        Matcher m = SupportedCommands.LINE_COMMAND.matcher(cmd);
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
    public Shape getShape() {
        return new LineShape(this.X1, this.Y1, this.X2, this.Y2);

    }
}
