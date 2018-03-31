package Canvas.Shapes;

import Canvas.DrawingArea;
import Canvas.DrawingPoint;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CanvasTests {

    @Test
    public void draw_canvas(){
        List<DrawingPoint> expectedDPs = IntStream.range(0, 6).mapToObj(x -> new DrawingPoint(x, 0, '-')).collect(Collectors.toList());
        expectedDPs.addAll(IntStream.range(1, 5).mapToObj(y -> new DrawingPoint(0,  y, '|')).collect(Collectors.toList()));
        expectedDPs.addAll(IntStream.range(1, 5).mapToObj(y -> new DrawingPoint(5,  y, '|')).collect(Collectors.toList()));
        expectedDPs.addAll(IntStream.range(0, 6).mapToObj(x -> new DrawingPoint(x, 5, '-')).collect(Collectors.toList()));
        Canvas canvas = new Canvas(4, 4);
        List<DrawingPoint> dps = canvas.Draw(new DrawingArea(4, 4));
        List<DrawingPoint> notMatching = dps.stream().filter(x -> !expectedDPs.contains(x)).collect(Collectors.toList());
        Assert.assertTrue(dps.stream().allMatch(x -> expectedDPs.contains(x)));
    }
}
