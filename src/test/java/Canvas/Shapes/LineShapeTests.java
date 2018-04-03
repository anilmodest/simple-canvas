package Canvas.Shapes;

import Canvas.DrawingPoint;
import Canvas.DrawingBoard;
import Canvas.Exceptions.ExceptionMessages;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.mockito.Mockito.*;

public class LineShapeTests {

    @Test
    public void draw_line() {
        List<DrawingPoint> expected = IntStream.range(1, 5).mapToObj(x -> new DrawingPoint(x, 1, 'x')).collect(Collectors.toList());
        LineShape lineShape = new LineShape(1, 1, 4, 1);
        DrawingBoard mockDrawingBoard = mock(DrawingBoard.class);
        when(mockDrawingBoard.getLength()).thenReturn(4);
        when(mockDrawingBoard.getHeight()).thenReturn(4);
        ArgumentCaptor<DrawingPoint> argsCaptor = ArgumentCaptor.forClass(DrawingPoint.class);
        String errorMessage = lineShape.Draw(mockDrawingBoard);
        verify(mockDrawingBoard, times(expected.size())).setPoint(argsCaptor.capture());
        Assert.assertEquals("", errorMessage);
        Assert.assertTrue(expected.stream().allMatch(x -> argsCaptor.getAllValues().contains(x)));
    }

    @Test
    public void should_draw_line_if_x1_greaterthan_x2() {
        List<DrawingPoint> expected = IntStream.range(1, 4).mapToObj(x -> new DrawingPoint(x, 1, 'x')).collect(Collectors.toList());
        LineShape lineShape = new LineShape(3, 1, 1, 1);
        DrawingBoard mockDrawingBoard = mock(DrawingBoard.class);
        when(mockDrawingBoard.getLength()).thenReturn(4);
        when(mockDrawingBoard.getHeight()).thenReturn(4);
        ArgumentCaptor<DrawingPoint> argsCaptor = ArgumentCaptor.forClass(DrawingPoint.class);
        String errorMessage = lineShape.Draw(mockDrawingBoard);
        verify(mockDrawingBoard, times(expected.size())).setPoint(argsCaptor.capture());
        Assert.assertEquals("", errorMessage);
        Assert.assertTrue(expected.stream().allMatch(x -> argsCaptor.getAllValues().contains(x)));
    }

    @Test
    public void only_horizontal_vertical_lines_supported() {
        LineShape lineShape = new LineShape(1, 1, 3, 4);
        DrawingBoard mockDrawingBoard = mock(DrawingBoard.class);
        when(mockDrawingBoard.getLength()).thenReturn(4);
        when(mockDrawingBoard.getHeight()).thenReturn(4);
        String errorMessage = lineShape.Draw(mockDrawingBoard);
        Assert.assertEquals(ExceptionMessages.ONLY_HORIZONTAL_VERTICAL_LINES_SUPPORTED, errorMessage);

    }

    @Test
    public void should_give_out_of_bound_message() {
        List<DrawingPoint> expected = IntStream.range(1, 4).mapToObj(x -> new DrawingPoint(x, 1, 'x')).collect(Collectors.toList());
        LineShape lineShape = new LineShape(1, 1, 13, 1);
        DrawingBoard mockDrawingBoard = mock(DrawingBoard.class);
        when(mockDrawingBoard.getLength()).thenReturn(4);
        when(mockDrawingBoard.getHeight()).thenReturn(4);
        String errorMessage = lineShape.Draw(mockDrawingBoard);
        Assert.assertEquals(ExceptionMessages.OUT_OF_BOUND, errorMessage);

    }
}
