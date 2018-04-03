package Canvas.Shapes;

import Canvas.DrawingPoint;
import Canvas.DrawingBoard;

import java.util.List;

public interface Shape {

    String Draw(DrawingBoard drawingBoard);

    default public Boolean isWithInBounds(int x, int y, int length, int height){
        Boolean isValid = true;
        if(x <= 0 || x > length) {
            isValid = false;
        }
        if(y <= 0 || y > height) {
            isValid = false;
        }
        return isValid;
    }


}
