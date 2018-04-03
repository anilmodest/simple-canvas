package Canvas;


public class DrawingPoint {

    private char drawingChar;
    private boolean isBucketFill;

    public DrawingPoint(int x, int y) {
        this(x, y , ' ');
    }

    public DrawingPoint(int x, int y, char drawingChar) {
        this(x, y , drawingChar, false);
    }

    public DrawingPoint(int x, int y, char drawingChar, boolean isBucketFill) {
        this.X = x;
        this.Y = y;
        this.drawingChar = drawingChar;
        this.isBucketFill = isBucketFill;
    }

    public int X;

    public int Y;

    public boolean getIsBucketFillChar(){
        return this.isBucketFill;
    }


    public Character getDrawingChar() {
        return drawingChar;
    }

    @Override
    public boolean equals(Object other) {
        if(other instanceof DrawingPoint)
        {
            DrawingPoint otherDP = (DrawingPoint) other;
             return this.X == otherDP.X && this.Y == otherDP.Y && this.drawingChar == otherDP.drawingChar && this.isBucketFill == otherDP.isBucketFill;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (this.X * 976) * this.Y * new Character(this.drawingChar).hashCode() * new Boolean(this.getIsBucketFillChar()).hashCode();
    }
}
