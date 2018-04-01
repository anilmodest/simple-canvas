package Canvas.Shapes;

import Canvas.DrawingPoint;
import Canvas.DrawingBoard;
import Canvas.Exceptions.ExceptionMessages;

import java.util.List;

public class Canvas implements IShape {


    private Integer length;
    private Integer height;
    private final static int maxLength = 300;
    private final static int maxHeight = 300;
    private final static char H_CHAR = '-';
    private final static char V_CHAR = '|';

    public Canvas(Integer length, Integer height) {

        this.length = length + 2;
        this.height = height + 2;
    }


    @Override
    public void Draw(DrawingBoard drawingBoard) throws Exception {

        if(this.length >= this.maxLength || this.height >= this.maxHeight) {
            throw new Exception(ExceptionMessages.MAX_CANVAS_SIZE);
        }
        ShapeUtility.getHorizatalLinePoints(0, this.length, 0, H_CHAR).forEach(dp -> drawingBoard.setPoint(dp));
        ShapeUtility.getVerticalLinePoints(1, this.height - 1, 0, V_CHAR).forEach(dp -> drawingBoard.setPoint(dp));
        ShapeUtility.getVerticalLinePoints(1, this.height - 1, this.length - 1, V_CHAR).forEach(dp -> drawingBoard.setPoint(dp));
        ShapeUtility.getHorizatalLinePoints(0, this.length, this.height - 1, H_CHAR).forEach(dp -> drawingBoard.setPoint(dp));
    }


}
