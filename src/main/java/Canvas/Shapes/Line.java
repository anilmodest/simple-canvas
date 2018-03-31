package Canvas.Shapes;

import Canvas.DrawingArea;
import Canvas.DrawingPoint;
import Canvas.Exceptions.InvalidLineException;
import com.sun.org.apache.xpath.internal.operations.Bool;
import jdk.nashorn.internal.runtime.ECMAException;

import java.util.List;

public class Line implements IShape {
    private Integer x1;
    private Integer y1;
    private Integer x2;
    private Integer y2;

    public Line(Integer x1, Integer y1, Integer
            x2, Integer y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public List<DrawingPoint> Draw(DrawingArea drawingArea) throws Exception {

        if(this.isOutOfBound(drawingArea.getLength(), drawingArea.getHeight())){
            throw new Exception("Line is out of bounds");
        }
        if(this.isHorizontalLine()) {
            return ShapeUtility.getHorizatalLinePoints(this.x1, this.x2, this.y1, '-');
        }
        else if(this.isVerticalLine()) {
            return ShapeUtility.getVerticalLinePoints(this.y1, this.y2, this.x1, '-');
        }
        else{
            throw new Exception("Only Horizontal and Vertical Lines are supported");
        }

    }

    private Boolean isOutOfBound(int length, int height){
        Boolean isValid = false;
        if(Integer.min(this.x1, this.x2) <= 0 || Integer.max(this.x1, this.x2) > length + 1) {
            isValid = true;
        }
        if(Integer.min(this.y1, this.y2) <= 0 || Integer.max(this.y1, this.y2) > height + 1) {
            isValid = true;
        }
        return isValid;
    }

    private Boolean isHorizontalLine(){
        return this.y1 == this.y2;
    }

    private Boolean isVerticalLine(){
        return this.x1 == this.x2;
    }
}
