package Canvas.Shapes;

import Canvas.DrawingArea;
import Canvas.DrawingPoint;

import java.util.List;

public class Canvas implements IShape {


    private Integer length;
    private Integer height;

    public Canvas(Integer length, Integer height) {

        this.length = length + 2;
        this.height = height + 2;
    }


    @Override
    public List<DrawingPoint> Draw(DrawingArea drawingArea) {

        List<DrawingPoint> dps = ShapeUtility.getHorizatalLinePoints(0, this.length, 0, '-');
        dps.addAll(ShapeUtility.getVerticalLinePoints(1, this.height - 1, 0, '|'));
        dps.addAll(ShapeUtility.getVerticalLinePoints(1, this.height - 1, this.length - 1, '|'));
        dps.addAll(ShapeUtility.getHorizatalLinePoints(0, this.length, this.height - 1, '-'));
        return dps;
    }
}
