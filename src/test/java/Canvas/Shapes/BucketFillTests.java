package Canvas.Shapes;


import Canvas.DrawingBoard;

import Canvas.Exceptions.ExceptionMessages;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BucketFillTests {


    @Test
    public void bucket_fill() throws Exception {
        DrawingBoard drawingBoard = new DrawingBoard(2, 2);
        BucketFillShape bucketFillShape = new BucketFillShape(1, 1, '@');
        CanvasShape canvasShape = new CanvasShape(2, 2);
        String errorMessage  = canvasShape.Draw(drawingBoard);
        errorMessage = bucketFillShape.Draw(drawingBoard);

        Assert.assertEquals("", errorMessage);
        Assert.assertEquals("----\n" +
                                     "|@@|\n" +
                                     "|@@|\n" +
                                     "----", drawingBoard.toString());

    }

    @Test
    public void should_refill_bucket_fill_if_drawn_at_same_point_with_new_char() throws Exception {
        DrawingBoard drawingBoard = new DrawingBoard(2, 2);
        BucketFillShape bucketFillShape = new BucketFillShape(1, 1, '@');
        CanvasShape canvasShape = new CanvasShape(2, 2);
        String errorMessage  = canvasShape.Draw(drawingBoard);
        errorMessage  = bucketFillShape.Draw(drawingBoard);

        Assert.assertEquals("----\n" +
                                     "|@@|\n" +
                                     "|@@|\n" +
                                     "----", drawingBoard.toString());

        bucketFillShape = new BucketFillShape(1, 1, '$');
        errorMessage  = bucketFillShape.Draw(drawingBoard);

        Assert.assertEquals("", errorMessage);
        Assert.assertEquals("----\n" +
                                     "|$$|\n" +
                                     "|$$|\n" +
                                     "----", drawingBoard.toString());

    }

    @Test
    public void should_not_fill_area_under_rectangle_if_fillinvoked_for_point_outside() throws Exception {
        DrawingBoard drawingBoard = new DrawingBoard(4, 4);
        BucketFillShape bucketFillShape = new BucketFillShape(1, 1, '@');
        CanvasShape canvasShape = new CanvasShape(4, 4);
        RectangleShape rectangleShape = new RectangleShape(1, 2, 4, 4);

        String errorMessage  = canvasShape.Draw(drawingBoard);
        errorMessage  = rectangleShape.Draw(drawingBoard);
        errorMessage  = bucketFillShape.Draw(drawingBoard);

        Assert.assertEquals("", errorMessage);
        Assert.assertEquals("------\n" +
                                     "|@@@@|\n" +
                                     "|xxxx|\n" +
                                     "|x  x|\n" +
                                     "|xxxx|\n" +
                                     "------", drawingBoard.toString());


    }

    @Test
    public void should_give_out_of_bound_if_point_out_of_bounds() throws Exception {
        DrawingBoard drawingBoard = new DrawingBoard(4, 4);
        BucketFillShape bucketFillShape = new BucketFillShape(10, 10, '@');
        String errorMessage  = bucketFillShape.Draw(drawingBoard);
        Assert.assertEquals(ExceptionMessages.OUT_OF_BOUND, errorMessage);
    }

    @Test
    public void should_not_fill_if_point_already_filled() throws Exception {
        DrawingBoard drawingBoard = new DrawingBoard(2, 2);
        CanvasShape canvasShape = new CanvasShape(2, 2);
        LineShape lineShape = new LineShape(1, 1, 2, 1);
        BucketFillShape bucketFillShape = new BucketFillShape(1, 1, '@');

        String errorMessage  =canvasShape.Draw(drawingBoard);
        errorMessage = lineShape.Draw(drawingBoard);
        errorMessage = bucketFillShape.Draw(drawingBoard);

        Assert.assertEquals("", errorMessage);
        Assert.assertEquals("----\n" +
                                     "|xx|\n" +
                                     "|  |\n" +
                                     "----", drawingBoard.toString());
    }
}
