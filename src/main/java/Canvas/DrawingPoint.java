package Canvas;


public class DrawingPoint {

    private char drawingChar;

    public DrawingPoint(int x, int y) {
        this(x, y , ' ');
    }

    public DrawingPoint(int x, int y, char drawingChar) {
        this.X = x;
        this.Y = y;
        this.drawingChar = drawingChar;
    }

    public int X;

    public int Y;


    public Character getDrawingChar() {
        return drawingChar;
    }

    @Override
    public boolean equals(Object other) {
        if(other instanceof DrawingPoint)
        {
            DrawingPoint otherDP = (DrawingPoint) other;
            return this.X == otherDP.X && this.Y == otherDP.Y && this.drawingChar ==otherDP.drawingChar;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (this.X * 976) * this.Y * new Character(this.drawingChar).hashCode();
    }
}
