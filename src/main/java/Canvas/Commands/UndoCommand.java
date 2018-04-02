package Canvas.Commands;

import Canvas.Shapes.IShape;

import java.util.regex.Matcher;

public class UndoCommand implements ICommand {

    @Override
    public Boolean isValid(String cmd) {
        Matcher m = SupportedCommands.UNDO_COMMAND.matcher(cmd);
        return m.matches();
    }

    @Override
    public IShape getShape() {
        return null;
    }
}
