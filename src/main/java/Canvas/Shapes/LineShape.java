package Canvas.Shapes;

import Canvas.DrawingBoard;
import Canvas.Exceptions.ExceptionMessages;


public class LineShape implements Shape {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private final static char LINE_CHAR = 'x';

    public LineShape(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public String Draw(DrawingBoard drawingBoard) {

        String errorMessage = "";
        int length = drawingBoard.getLength();
        int height = drawingBoard.getHeight();

        if(!this.isWithInBounds(this.x1, this.y1, length, height) || !this.isWithInBounds(this.x2, this.y2, length, height)){
            errorMessage = ExceptionMessages.OUT_OF_BOUND;
        }
        else if(this.isHorizontalLine()) {
            ShapeUtility.getHorizatalLinePoints(this.x1, this.x2, this.y1, LINE_CHAR).forEach(dp -> drawingBoard.setPoint(dp));
        }
        else if(this.isVerticalLine()) {
            ShapeUtility.getVerticalLinePoints(this.y1, this.y2, this.x1, LINE_CHAR).forEach(dp -> drawingBoard.setPoint(dp));
        }
        else{
            errorMessage = ExceptionMessages.ONLY_HORIZONTAL_VERTICAL_LINES_SUPPORTED;
        }

        return errorMessage;
    }


    private Boolean isHorizontalLine(){
        return this.y1 == this.y2;
    }

    private Boolean isVerticalLine(){
        return this.x1 == this.x2;
    }
}
