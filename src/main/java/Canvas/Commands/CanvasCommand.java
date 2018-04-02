package Canvas.Commands;

import Canvas.Shapes.Canvas;
import Canvas.Shapes.IShape;

import java.util.regex.Matcher;

public class CanvasCommand implements ICommand {
    private Integer length;
    private Integer height;
    private IShape canvas;

    public Integer getLength(){
        return this.length;
    }

    public Integer getHeight() {
        return height;
    }

    public IShape getShape(){
        return this.canvas = new Canvas(this.length, this.height);
    }

    public Boolean isValid(String cmd) {
        Matcher m = SupportedCommands.CANVAS_COMMAND.matcher(cmd);
        if(m.matches()){
            this.length = Integer.parseInt(m.group("Length"));
            this.height = Integer.parseInt(m.group("Height"));
            return true;
        }

        return false;
    }

}
