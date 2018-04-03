package Canvas.Commands;

import Canvas.Shapes.Shape;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.regex.Matcher;

public class HelpCommandWrapper implements CommandWrapper {

    @Override
    public Boolean isValid(String cmd) {
        Matcher m = SupportedCommands.HELP_COMMAND.matcher(cmd);
        return m.matches();
    }

    @Override
    public Shape getShape() {
        throw new NotImplementedException();
    }
}
