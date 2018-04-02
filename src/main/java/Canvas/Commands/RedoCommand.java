package Canvas.Commands;

import Canvas.Shapes.IShape;

import java.util.regex.Matcher;

public class RedoCommand implements ICommand {

    @Override
    public Boolean isValid(String cmd) {
        Matcher m = SupportedCommands.REDO_COMMAND.matcher(cmd);
        return m.matches();
    }

    @Override
    public IShape getShape() {
        return null;
    }
}
