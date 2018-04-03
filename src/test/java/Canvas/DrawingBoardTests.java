package Canvas;

import Canvas.Shapes.CanvasShape;
import Canvas.Shapes.LineShape;
import Canvas.Shapes.RectangleShape;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DrawingBoardTests {

    @Test
    public void should_return_valid_shape(){
        DrawingBoard drawingBoard = new DrawingBoard(4, 4 );
        drawingBoard.setPoint(new DrawingPoint(0, 0, '-'));
        drawingBoard.setPoint(new DrawingPoint(1, 0, '-'));
        drawingBoard.setPoint(new DrawingPoint(2, 0, '-'));
        drawingBoard.setPoint(new DrawingPoint(3, 0, '-'));

        Assert.assertEquals("----  \n" +
                                     "      \n" +
                                     "      \n" +
                                     "      \n" +
                                     "      \n" +
                                     "      ", drawingBoard.toString());
    }

    @Test
    public void should_render_canvas_and_line() throws Exception {
        CanvasShape canvasShape = new CanvasShape(4, 4);
        DrawingBoard drawingBoard = new DrawingBoard(4, 4);
        LineShape firstLineShape = new LineShape(1, 2, 4, 2);
        LineShape secondLineShape = new LineShape(1, 2, 1, 4);

        canvasShape.Draw(drawingBoard);
        firstLineShape.Draw(drawingBoard);
        secondLineShape.Draw(drawingBoard);
        Assert.assertEquals("------\n" +
                                     "|    |\n" +
                                     "|xxxx|\n" +
                                     "|x   |\n" +
                                     "|x   |\n" +
                                     "------", drawingBoard.toString());

    }

    @Test
    public void should_render_canvas_and_rectangle() throws Exception {
        DrawingBoard drawingBoard = new DrawingBoard(4, 4);
        CanvasShape canvasShape = new CanvasShape(4, 4);
        RectangleShape rectangleShape = new RectangleShape(1, 1, 4, 4);

        canvasShape.Draw(drawingBoard);
        rectangleShape.Draw(drawingBoard);

        Assert.assertEquals("------\n" +
                                     "|xxxx|\n" +
                                     "|x  x|\n" +
                                     "|x  x|\n" +
                                     "|xxxx|\n" +
                                     "------", drawingBoard.toString());

    }
}
