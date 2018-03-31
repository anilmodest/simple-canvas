package Canvas.Commands;

import Canvas.Shapes.IShape;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelpCommand implements ICommand {
    private Pattern helpCommand= Pattern.compile("^[h|H]");

    @Override
    public Boolean isValid(String cmd) {
        Matcher m = this.helpCommand.matcher(cmd);
        return m.matches();
    }

    @Override
    public IShape getShape() {
        throw new NotImplementedException();
    }
}
