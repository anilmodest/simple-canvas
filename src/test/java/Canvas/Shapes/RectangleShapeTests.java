package Canvas.Shapes;

import Canvas.Exceptions.ExceptionMessages;
import org.junit.Assert;
import org.junit.Test;
import Canvas.DrawingPoint;
import Canvas.DrawingBoard;
import org.mockito.ArgumentCaptor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.mockito.Mockito.*;


public class RectangleShapeTests {



    @Test
    public void should_draw_rectangle() throws Exception {

      DrawingBoard mockDrawingBoard = mock(DrawingBoard.class);
      when(mockDrawingBoard.getLength()).thenReturn(4);
      when(mockDrawingBoard.getHeight()).thenReturn(4);
      RectangleShape rectangleShape = new RectangleShape(1, 1, 4, 4);
      List<DrawingPoint> expected = IntStream.range(1, 5).mapToObj(x -> new DrawingPoint(x, 1, 'x')).collect(Collectors.toList());
      expected.addAll(IntStream.range(1, 5).mapToObj(y -> new DrawingPoint(4, y, 'x')).collect(Collectors.toList()));
      expected.addAll(IntStream.range(1, 5).mapToObj(x -> new DrawingPoint(x, 4, 'x')).collect(Collectors.toList()));
      expected.addAll(IntStream.range(1, 5).mapToObj(y -> new DrawingPoint(1, y, 'x')).collect(Collectors.toList()));
        ArgumentCaptor<DrawingPoint> argsCaptor = ArgumentCaptor.forClass(DrawingPoint.class);
      String errorMessage = rectangleShape.Draw(mockDrawingBoard);
      verify(mockDrawingBoard, times(expected.size())).setPoint(argsCaptor.capture());
      Assert.assertEquals("", errorMessage);
      Assert.assertTrue(expected.stream().allMatch(x -> argsCaptor.getAllValues().contains(x)));

    }

    @Test
    public void should_throw_exception_if_rectangle_out_of_bounds() throws Exception {

        DrawingBoard drawingBoard = mock(DrawingBoard.class);
        RectangleShape rectangleShape = new RectangleShape(1, 1, 8, 8);
        String errorMessage = rectangleShape.Draw(drawingBoard);
        Assert.assertEquals(ExceptionMessages.OUT_OF_BOUND, errorMessage);
    }
}
