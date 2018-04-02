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

public class CanvasTests {

    @Test
    public void draw_canvas() throws Exception {
        Canvas canvas = new Canvas(4, 4);
        List<DrawingPoint> expected = IntStream.range(0, 6).mapToObj(x -> new DrawingPoint(x, 0, '-')).collect(Collectors.toList());
        expected.addAll(IntStream.range(1, 5).mapToObj(y -> new DrawingPoint(5, y, '|')).collect(Collectors.toList()));
        expected.addAll(IntStream.range(0, 6).mapToObj(x -> new DrawingPoint(x, 5, '-')).collect(Collectors.toList()));
        expected.addAll(IntStream.range(1, 5).mapToObj(y -> new DrawingPoint(0, y, '|')).collect(Collectors.toList()));

        DrawingBoard mockDrawingBoard = mock(DrawingBoard.class);
        when(mockDrawingBoard.getLength()).thenReturn(4);
        when(mockDrawingBoard.getHeight()).thenReturn(4);
        ArgumentCaptor<DrawingPoint> argsCaptor = ArgumentCaptor.forClass(DrawingPoint.class);

        canvas.Draw(mockDrawingBoard);

        verify(mockDrawingBoard, times(expected.size())).setPoint(argsCaptor.capture());
        Assert.assertTrue(expected.stream().allMatch(x -> argsCaptor.getAllValues().contains(x)));
    }
}
