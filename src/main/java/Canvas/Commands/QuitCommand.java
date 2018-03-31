package Canvas.Commands;

import Canvas.Shapes.IShape;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuitCommand implements ICommand {

    private Pattern quitCommand= Pattern.compile("^[q|Q]");

    @Override
    public Boolean isValid(String cmd) {
        Matcher m = this.quitCommand.matcher(cmd);
        return m.matches();
    }

    @Override
    public IShape getShape() {
        throw new NotImplementedException();
    }
}
