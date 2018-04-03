package Canvas.Commands;

import Canvas.Shapes.CanvasShape;
import Canvas.Shapes.Shape;

import java.util.regex.Matcher;

public class CanvasCommandWrapper implements CommandWrapper {
    private Integer length;
    private Integer height;
    private Shape canvas;

    public Integer getLength(){
        return this.length;
    }

    public Integer getHeight() {
        return height;
    }

    public Shape getShape(){
        return this.canvas = new CanvasShape(this.length, this.height);
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
