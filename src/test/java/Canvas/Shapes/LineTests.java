package Canvas.Shapes;

import Canvas.DrawingPoint;
import Canvas.DrawingBoard;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.mockito.Mockito.*;

public class LineTests {

    @Test
    public void draw_line() throws Exception {
        List<DrawingPoint> expected = IntStream.range(1, 5).mapToObj(x -> new DrawingPoint(x, 1, '-')).collect(Collectors.toList());
        Line line = new Line(1, 1, 4, 1);
        DrawingBoard mockDrawingBoard = mock(DrawingBoard.class);
        when(mockDrawingBoard.getLength()).thenReturn(4);
        when(mockDrawingBoard.getHeight()).thenReturn(4);
        ArgumentCaptor<DrawingPoint> argsCaptor = ArgumentCaptor.forClass(DrawingPoint.class);
        line.Draw(mockDrawingBoard);
        verify(mockDrawingBoard, times(expected.size())).setPoint(argsCaptor.capture());
        Assert.assertTrue(expected.stream().allMatch(x -> argsCaptor.getAllValues().contains(x)));
    }

    @Test
    public void should_draw_line_if_x1_greaterthan_x2() throws Exception {
        List<DrawingPoint> expected = IntStream.range(1, 4).mapToObj(x -> new DrawingPoint(x, 1, '-')).collect(Collectors.toList());
        Line line = new Line(3, 1, 1, 1);
        DrawingBoard mockDrawingBoard = mock(DrawingBoard.class);
        when(mockDrawingBoard.getLength()).thenReturn(4);
        when(mockDrawingBoard.getHeight()).thenReturn(4);
        ArgumentCaptor<DrawingPoint> argsCaptor = ArgumentCaptor.forClass(DrawingPoint.class);
        line.Draw(mockDrawingBoard);
        verify(mockDrawingBoard, times(expected.size())).setPoint(argsCaptor.capture());
        Assert.assertTrue(expected.stream().allMatch(x -> argsCaptor.getAllValues().contains(x)));
    }

    @Test(expected = Exception.class)
    public void only_horizontal_vertical_lines_supported() throws Exception {
        List<DrawingPoint> expected = IntStream.range(1, 5).mapToObj(x -> new DrawingPoint(x, 1, '-')).collect(Collectors.toList());
        Line line = new Line(1, 1, 3, 4);
        DrawingBoard mockDrawingBoard = mock(DrawingBoard.class);
        line.Draw(mockDrawingBoard);

    }

    @Test(expected = Exception.class)
    public void should_throw_outofbound_exception() throws Exception {
        List<DrawingPoint> expected = IntStream.range(1, 4).mapToObj(x -> new DrawingPoint(x, 1, '-')).collect(Collectors.toList());
        Line line = new Line(1, 1, 13, 1);
        DrawingBoard mockDrawingBoard = mock(DrawingBoard.class);
        when(mockDrawingBoard.getLength()).thenReturn(4);
        when(mockDrawingBoard.getHeight()).thenReturn(4);
        line.Draw(mockDrawingBoard);

    }
}
