package Canvas;
import Canvas.Shapes.Canvas;

public class DrawingArea {

    private Canvas canvas;
    private Integer length;
    private Integer height;

    public DrawingArea(Integer length, Integer height) {
        this.length = length;
        this.height = height;
    }

    public Integer getLength(){
        return this.length;
    }


    public Integer getHeight() {
        return this.height;
    }
}
