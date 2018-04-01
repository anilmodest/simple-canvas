package Canvas.Shapes;


import Canvas.DrawingBoard;
import Canvas.DrawingPoint;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BucketFillTests {


    @Test
    public void bucket_fill() throws Exception {
        DrawingBoard drawingBoard = new DrawingBoard(2, 2);
        BucketFill bucketFill = new BucketFill(1, 1);
        Canvas canvas = new Canvas(2, 2);
        canvas.Draw(drawingBoard);
        bucketFill.Draw(drawingBoard);

        Assert.assertEquals("----\n|@@|\n|@@|\n----", drawingBoard.toString());

    }

    @Test
    public void should_not_fill_area_under_rectangle_if_fillinvoked_for_point_outside() throws Exception {
        DrawingBoard drawingBoard = new DrawingBoard(4, 4);
        BucketFill bucketFill = new BucketFill(1, 1);
        Canvas canvas = new Canvas(4, 4);
        Rectangle rectangle = new Rectangle(1, 2, 4, 4);

        canvas.Draw(drawingBoard);
        rectangle.Draw(drawingBoard);
        bucketFill.Draw(drawingBoard);

        Assert.assertEquals("------\n|@@@@|\n|****|\n|*  *|\n|****|\n------", drawingBoard.toString());

    }

    @Test(expected = Exception.class)
    public void should_throw_exception_if_point_out_of_bounds() throws Exception {
        DrawingBoard drawingBoard = new DrawingBoard(4, 4);
        BucketFill bucketFill = new BucketFill(10, 10);
        bucketFill.Draw(drawingBoard);
    }

    @Test
    public void should_not_fill_if_point_already_filled() throws Exception {
        DrawingBoard drawingBoard = new DrawingBoard(2, 2);
        Canvas canvas = new Canvas(2, 2);
        Line line= new Line(1, 1, 2, 1);
        BucketFill bucketFill = new BucketFill(1, 1);

        canvas.Draw(drawingBoard);
        line.Draw(drawingBoard);
        bucketFill.Draw(drawingBoard);

        Assert.assertEquals("----\n|--|\n|  |\n----", drawingBoard.toString());
    }
}
