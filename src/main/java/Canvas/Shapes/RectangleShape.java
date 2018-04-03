package Canvas.Shapes;

import Canvas.DrawingBoard;
import Canvas.Exceptions.ExceptionMessages;

public class RectangleShape implements Shape {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private final static char RECT_CHAR = 'x';

    public RectangleShape(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;

    }

    @Override
    public String Draw(DrawingBoard drawingBoard) {
        String errorMessage = "";
        int length = drawingBoard.getLength();
        int height = drawingBoard.getHeight();
        if(!this.isWithInBounds(this.x1, this.y1, length, height) || !this.isWithInBounds(this.x2, this.y2, length, height)){
            errorMessage = ExceptionMessages.OUT_OF_BOUND;
        }
        else {
            ShapeUtility.getHorizatalLinePoints(this.x1, this.x2, this.y1, RECT_CHAR).forEach(dp -> drawingBoard.setPoint(dp));
            ShapeUtility.getVerticalLinePoints(this.y1, this.y2, this.x2, RECT_CHAR).forEach(dp -> drawingBoard.setPoint(dp));
            ShapeUtility.getVerticalLinePoints(this.y1, this.y2, this.x1, RECT_CHAR).forEach(dp -> drawingBoard.setPoint(dp));
            ShapeUtility.getHorizatalLinePoints(this.x1, this.x2, this.y2, RECT_CHAR).forEach(dp -> drawingBoard.setPoint(dp));
        }
        return errorMessage;
    }

}
