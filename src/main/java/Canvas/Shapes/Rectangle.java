package Canvas.Shapes;

import Canvas.DrawingPoint;
import Canvas.DrawingBoard;
import Canvas.Exceptions.ExceptionMessages;

import java.util.List;

public class Rectangle implements IShape {
    private Integer x1;
    private Integer y1;
    private Integer x2;
    private Integer y2;
    private final static char RECT_CHAR = 'x';

    public Rectangle(Integer x1, Integer y1, Integer x2, Integer y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;

    }

    @Override
    public void Draw(DrawingBoard drawingBoard) throws Exception {

        int length = drawingBoard.getLength();
        int height = drawingBoard.getHeight();
        if(!ShapeUtility.isWithInBounds(this.x1, this.y1, length, height) || !ShapeUtility.isWithInBounds(this.x2, this.y2, length, height)){
            throw new Exception(ExceptionMessages.OUT_OF_BOUND);
        }

        ShapeUtility.getHorizatalLinePoints(Integer.min(this.x1, this.x2), Integer.max(this.x1, this.x2) + 1 , this.y1, RECT_CHAR).forEach(dp -> drawingBoard.setPoint(dp));
        ShapeUtility.getVerticalLinePoints(Integer.min(this.y1, this.y2), Integer.max(this.y1, this.y2) + 1 , this.x2, RECT_CHAR).forEach(dp -> drawingBoard.setPoint(dp));
        ShapeUtility.getVerticalLinePoints(Integer.min(this.y1, this.y2), Integer.max(this.y1, this.y2) + 1 , this.x1, RECT_CHAR).forEach(dp -> drawingBoard.setPoint(dp));
        ShapeUtility.getHorizatalLinePoints(Integer.min(this.x1, this.x2), Integer.max(this.x1, this.x2) + 1 , this.y2, RECT_CHAR).forEach(dp -> drawingBoard.setPoint(dp));

    }

}
