package Canvas.Shapes;


import Canvas.DrawingPoint;
import Canvas.DrawingBoard;

import java.awt.*;
import java.util.List;
import java.util.Optional;
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

        if(!ShapeUtility.isWithInBounds(this.x, this.y, drawingBoard.getLength(), drawingBoard.getHeight())){
            throw new Exception("Point is out of bounds");
        }
        Optional<DrawingPoint> existingPoint = drawingBoard.getDrawingPoint(this.x, this.y);
        if(existingPoint != null && existingPoint.isPresent()) {
            return;
        }

        Stack<DrawingPoint> points = new Stack<>();
        points.push(new DrawingPoint(this.x, this.y));
        while(!points.empty()) {
            DrawingPoint currentPoint = points.pop();
            getNeighbours(currentPoint).stream().filter(p -> ShapeUtility.isWithInBounds(p.X, p.Y, drawingBoard.getLength(), drawingBoard.getHeight())).
                    filter(p -> drawingBoard.getDrawingPoint(p.X, p.Y) == null || !drawingBoard.getDrawingPoint(p.X, p.Y).isPresent()).forEach(bp -> {
                        if(!points.contains(bp)){
                            points.push(bp);
                        }
                        drawingBoard.setPoint(new DrawingPoint(bp.X, bp.Y, '@'));
            });
        }
    }

    private Stack<DrawingPoint> getNeighbours(DrawingPoint point) {
        Stack<DrawingPoint> neighbours = new Stack<>();
        neighbours.push(new DrawingPoint(point.X + 1, point.Y));
        neighbours.push(new DrawingPoint(point.X - 1, point.Y));
        neighbours.push(new DrawingPoint(point.X, point.Y + 1));
        neighbours.push(new DrawingPoint(point.X, point.Y - 1 ));
        return neighbours;
    }
}
