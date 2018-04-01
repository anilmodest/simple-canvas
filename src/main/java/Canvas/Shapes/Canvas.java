package Canvas.Shapes;

import Canvas.DrawingPoint;
import Canvas.DrawingBoard;

import java.util.List;

public class Canvas implements IShape {


    private Integer length;
    private Integer height;

    public Canvas(Integer length, Integer height) {

        this.length = length + 2;
        this.height = height + 2;
    }


    @Override
    public void Draw(DrawingBoard drawingBoard) {
        ShapeUtility.getHorizatalLinePoints(0, this.length, 0, '-').forEach(dp -> drawingBoard.setPoint(dp));
        ShapeUtility.getVerticalLinePoints(1, this.height - 1, 0, '|').forEach(dp -> drawingBoard.setPoint(dp));
        ShapeUtility.getVerticalLinePoints(1, this.height - 1, this.length - 1, '|').forEach(dp -> drawingBoard.setPoint(dp));
        ShapeUtility.getHorizatalLinePoints(0, this.length, this.height - 1, '-').forEach(dp -> drawingBoard.setPoint(dp));
    }
}
