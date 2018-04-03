package Canvas.Shapes;

import Canvas.DrawingBoard;
import Canvas.Exceptions.ExceptionMessages;

public class CanvasShape implements Shape {


    private int length;
    private int height;
    private final static int maxLength = 300;
    private final static int maxHeight = 300;
    private final static char H_CHAR = '-';
    private final static char V_CHAR = '|';

    public CanvasShape(int length, int height) {

        this.length = length + 2;
        this.height = height + 2;
    }


    @Override
    public String Draw(DrawingBoard drawingBoard) {
        String errorMessage = "";

        if(this.length >= this.maxLength || this.height >= this.maxHeight) {
            errorMessage = ExceptionMessages.MAX_CANVAS_SIZE;
        }
        else {
            ShapeUtility.getHorizatalLinePoints(0, this.length - 1, 0, H_CHAR).forEach(dp -> drawingBoard.setPoint(dp));
            ShapeUtility.getVerticalLinePoints(1, this.height - 2, 0, V_CHAR).forEach(dp -> drawingBoard.setPoint(dp));
            ShapeUtility.getVerticalLinePoints(1, this.height - 2, this.length - 1, V_CHAR).forEach(dp -> drawingBoard.setPoint(dp));
            ShapeUtility.getHorizatalLinePoints(0, this.length - 1, this.height - 1, H_CHAR).forEach(dp -> drawingBoard.setPoint(dp));
        }
        return errorMessage;
    }


}
