package Canvas.Shapes;

import org.junit.Assert;
import org.junit.Test;
import Canvas.DrawingPoint;
import Canvas.DrawingBoard;
import org.mockito.ArgumentCaptor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.mockito.Mockito.*;


public class RectangleTests {



    @Test
    public void should_draw_rectangle() throws Exception {

      DrawingBoard mockDrawingBoard = mock(DrawingBoard.class);
      when(mockDrawingBoard.getLength()).thenReturn(4);
      when(mockDrawingBoard.getHeight()).thenReturn(4);
      Rectangle rectangle = new Rectangle(1, 1, 4, 4);
      List<DrawingPoint> expected = IntStream.range(1, 5).mapToObj(x -> new DrawingPoint(x, 1, '*')).collect(Collectors.toList());
      expected.addAll(IntStream.range(1, 5).mapToObj(y -> new DrawingPoint(4, y, '*')).collect(Collectors.toList()));
      expected.addAll(IntStream.range(1, 5).mapToObj(x -> new DrawingPoint(x, 4, '*')).collect(Collectors.toList()));
      expected.addAll(IntStream.range(1, 5).mapToObj(y -> new DrawingPoint(1, y, '*')).collect(Collectors.toList()));
        ArgumentCaptor<DrawingPoint> argsCaptor = ArgumentCaptor.forClass(DrawingPoint.class);
      rectangle.Draw(mockDrawingBoard);
      verify(mockDrawingBoard, times(expected.size())).setPoint(argsCaptor.capture());
      Assert.assertTrue(expected.stream().allMatch(x -> argsCaptor.getAllValues().contains(x)));

    }

    @Test(expected = Exception.class)
    public void should_throw_exception_if_rectangle_out_of_bounds() throws Exception {

        DrawingBoard drawingBoard = mock(DrawingBoard.class);
        Rectangle rectangle = new Rectangle(1, 1, 8, 8);
        rectangle.Draw(drawingBoard);
    }
}
