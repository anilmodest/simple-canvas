package Canvas.Shapes;


import Canvas.DrawingPoint;
import Canvas.DrawingBoard;
import Canvas.Exceptions.ExceptionMessages;

import java.awt.*;
import java.util.List;
import java.util.Optional;
import java.util.Stack;

public class BucketFill implements IShape {
    private int x;
    private int y;
    private char drawingChar;

    public BucketFill(int x, int y, char drawingChar) {
        this.x = x;
        this.y = y;
        this.drawingChar = drawingChar;
    }

    @Override
    public void Draw(DrawingBoard drawingBoard) throws Exception {

        if(!ShapeUtility.isWithInBounds(this.x, this.y, drawingBoard.getLength(), drawingBoard.getHeight())){
            throw new Exception(ExceptionMessages.OUT_OF_BOUND);
        }
        Optional<DrawingPoint> existingPoint = drawingBoard.getDrawingPoint(this.x, this.y);
        if(existingPoint != null) {
            DrawingPoint point = existingPoint.isPresent() ? existingPoint.get() : null;
            if(!point.getIsBucketFillChar()) {
                return;
            }
        }

        Stack<DrawingPoint> points = new Stack<>();
        points.push(new DrawingPoint(this.x, this.y));
        while(!points.empty()) {
            DrawingPoint currentPoint = points.pop();
            getNeighbours(currentPoint).stream().filter(p -> ShapeUtility.isWithInBounds(p.X, p.Y, drawingBoard.getLength(), drawingBoard.getHeight())).
                    filter(p -> this.isPointEligibleForFill(drawingBoard.getDrawingPoint(p.X, p.Y))).forEach(bp -> {
                        if(!points.contains(bp)){
                            points.push(bp);
                        }
                        drawingBoard.setPoint(new DrawingPoint(bp.X, bp.Y, this.drawingChar, true));
            });
        }
    }

    private boolean isPointEligibleForFill(Optional<DrawingPoint> drawingPoint) {
        boolean isEligible = true;
        if(drawingPoint != null) {
            if (drawingPoint.isPresent()) {
                DrawingPoint dp = drawingPoint.get();
                isEligible = dp.getIsBucketFillChar() && dp.getDrawingChar() != this.drawingChar;
            }
        }
        return isEligible;
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
