package Canvas.Commands;

import Canvas.Shapes.IShape;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RedoCommand implements ICommand {
    private Pattern undoCommand = Pattern.compile("^[r|R]");

    @Override
    public Boolean isValid(String cmd) {
        Matcher m = this.undoCommand.matcher(cmd);
        return m.matches();
    }

    @Override
    public IShape getShape() {
        return null;
    }
}
