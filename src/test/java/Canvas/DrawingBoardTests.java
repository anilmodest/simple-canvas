package Canvas;

import Canvas.Renderer.IConsole;
import Canvas.Renderer.IRenderer;
import Canvas.Renderer.Renderer;
import Canvas.Renderer.SystemConsole;
import Canvas.Shapes.Canvas;
import Canvas.Shapes.Line;
import Canvas.Shapes.Rectangle;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;

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

        Assert.assertEquals("----  \n      \n      \n      \n      \n      ", drawingBoard.toString());
    }

    @Test
    public void should_render_canvas_and_line() throws Exception {
        Canvas canvas = new Canvas(4, 4);
        DrawingBoard drawingBoard = new DrawingBoard(4, 4);
        Line firstLine = new Line(1, 2, 4, 2);
        Line secondLine = new Line(1, 3, 4, 3);

        canvas.Draw(drawingBoard);
        firstLine.Draw(drawingBoard);
        secondLine.Draw(drawingBoard);
        Assert.assertEquals("------\n|    |\n|----|\n|----|\n|    |\n------", drawingBoard.toString());

    }

    @Test
    public void should_render_canvas_and_rectangle() throws Exception {
        DrawingBoard drawingBoard = new DrawingBoard(4, 4);
        Canvas canvas = new Canvas(4, 4);
        Rectangle rectangle = new Rectangle(1, 1, 4, 4);

        canvas.Draw(drawingBoard);
        rectangle.Draw(drawingBoard);

        Assert.assertEquals("------\n|****|\n|*  *|\n|*  *|\n|****|\n------", drawingBoard.toString());

    }
}
