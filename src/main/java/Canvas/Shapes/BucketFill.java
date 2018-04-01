package Canvas.Shapes;


import Canvas.DrawingPoint;
import Canvas.DrawingBoard;

import java.awt.*;
import java.util.List;
import java.util.Stack;

public class BucketFill implements IShape {
    private int x;
    private int y;

    public BucketFill(int x, int y) {


        this.x = x;
        this.y = y;
    }

    @Override
    public void Draw(DrawingBoard drawingBoard) throws Exception {
        Stack<Point> points = new Stack<>();
        points.push(new Point(this.x, this.y));
        while(!points.empty()) {
            Point point = points.pop();
            getNeighbours(point).stream().filter(p -> ShapeUtility.isWithInBounds(p.x, p.y, drawingBoard.getLength(), drawingBoard.getHeight())).
                    filter(p -> !drawingBoard.getDrawingPoint(p.x, p.y).isPresent()).forEach(bp -> {
                        drawingBoard.setPoint(new DrawingPoint(bp.x, bp.y, '@'));
            });
        }
    }

    private Stack<Point> getNeighbours(Point point) {
        Stack<Point> neighbours = new Stack<>();
        neighbours.push(new Point(point.x + 1, point.y));
        neighbours.push(new Point(point.x - 1, point.y));
        neighbours.push(new Point(point.x, point.y + 1));
        neighbours.push(new Point(point.x, point.y - 1 ));
        return neighbours;
    }
}
