package Canvas.Shapes;

import Canvas.DrawingPoint;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ShapeUtility {

    public static List<DrawingPoint> getHorizatalLinePoints(int x1, int x2, int y, char drawingChar) {
        return IntStream.range(x1, x2).mapToObj(x -> new DrawingPoint(x, y, drawingChar)).collect(Collectors.toList());
    }

    public static List<DrawingPoint> getVerticalLinePoints(int y1, int y2, int x, char drawingChar) {
        return IntStream.range(y1, y2).mapToObj(y -> new DrawingPoint(x, y, drawingChar)).collect(Collectors.toList());
    }
}
