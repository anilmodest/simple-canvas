package Canvas.Commands;

import Canvas.Shapes.IShape;
import Canvas.Shapes.Line;

import java.util.regex.Matcher;

public class LineCommand implements ICommand {

    private Integer X1;
    private Integer Y1;
    private Integer X2;
    private Integer Y2;
    private IShape line;

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
    public IShape getShape() {
        return new Line(this.X1, this.Y1, this.X2, this.Y2);

    }
}
