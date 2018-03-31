package Canvas.Commands;

import Canvas.Shapes.Canvas;
import Canvas.Shapes.IShape;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.in;

public class CanvasCommand implements ICommand {
    private Pattern _canvasRegPattern= Pattern.compile("^[C|c]\\s(?<Length>\\d+)\\s(?<Height>\\d+)$");
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
        Matcher m = _canvasRegPattern.matcher(cmd);
        if(m.matches()){
            this.length = Integer.parseInt(m.group("Length"));
            this.height = Integer.parseInt(m.group("Height"));
            return true;
        }

        return false;
    }

}
