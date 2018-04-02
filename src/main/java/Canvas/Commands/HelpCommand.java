package Canvas.Commands;

import Canvas.Shapes.IShape;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.regex.Matcher;

public class HelpCommand implements ICommand {

    @Override
    public Boolean isValid(String cmd) {
        Matcher m = SupportedCommands.HELP_COMMAND.matcher(cmd);
        return m.matches();
    }

    @Override
    public IShape getShape() {
        throw new NotImplementedException();
    }
}
