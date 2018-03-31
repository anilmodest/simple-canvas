package Canvas.Commands;

import Canvas.Shapes.IShape;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UndoCommand implements ICommand {
    private Pattern undoCommand = Pattern.compile("^[u|U]");

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
