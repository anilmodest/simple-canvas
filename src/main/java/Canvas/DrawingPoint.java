package Canvas;

import java.awt.*;

public class DrawingPoint {

    private Point point;
    private Character drawingChar;

    public Point getPoint() {
        return this.point;
    }

    public DrawingPoint(Integer x, Integer y, char drawingChar) {
        this.point = new Point(x, y);
        this.drawingChar = drawingChar;
    }


    public Character getDrawingChar() {
        return drawingChar;
    }

    @Override
    public boolean equals(Object other) {
        if(other instanceof DrawingPoint)
        {
            DrawingPoint otherDP = (DrawingPoint) other;
            return this.point.x == otherDP.getPoint().x && this.point.y == otherDP.getPoint().y && this.drawingChar ==otherDP.drawingChar;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.point.hashCode()*this.drawingChar.hashCode();
    }
}
