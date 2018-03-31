package Canvas.Shapes;

import Canvas.DrawingArea;
import Canvas.DrawingPoint;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LineTests {

    @Test
    public void draw_line() throws Exception {
        List<DrawingPoint> expected = IntStream.range(0, 4).mapToObj(x -> new DrawingPoint(x, 1, '-')).collect(Collectors.toList());
        Line line = new Line(1, 1, 4, 1);
        List<DrawingPoint> actual = line.Draw(new DrawingArea(4, 4));
        Assert.assertTrue(actual.stream().allMatch(x -> expected.contains(x)));
    }

    @Test
    public void should_draw_line_if_x1_greaterthan_x2() throws Exception {
        List<DrawingPoint> expected = IntStream.range(0, 3).mapToObj(x -> new DrawingPoint(x, 1, '-')).collect(Collectors.toList());
        Line line = new Line(3, 1, 1, 1);
        List<DrawingPoint> actual = line.Draw(new DrawingArea(4, 4));
        Assert.assertTrue(actual.stream().allMatch(x -> expected.contains(x)));
    }

    @Test(expected = Exception.class)
    public void only_horizontal_vertical_lines_supported() throws Exception {
        List<DrawingPoint> expected = IntStream.range(0, 3).mapToObj(x -> new DrawingPoint(x, 1, '-')).collect(Collectors.toList());
        Line line = new Line(1, 1, 3, 4);
        DrawingArea drawingArea = new DrawingArea(4, 4);
        line.Draw(drawingArea);

    }

    @Test(expected = Exception.class)
    public void should_throw_outofbound_exception() throws Exception {
        List<DrawingPoint> expected = IntStream.range(0, 3).mapToObj(x -> new DrawingPoint(x, 1, '-')).collect(Collectors.toList());
        Line line = new Line(1, 1, 13, 1);
        DrawingArea drawingArea = new DrawingArea(4, 4);
        line.Draw(drawingArea);

    }
}
