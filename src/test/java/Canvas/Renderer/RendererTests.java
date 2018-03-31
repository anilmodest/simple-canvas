package Canvas.Renderer;

import Canvas.DrawingArea;
import Canvas.DrawingPoint;
import Canvas.Shapes.Canvas;
import Canvas.Shapes.Line;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class RendererTests {

    @Test
    public void should_render_shape(){
        IConsole mockConsole = mock(SystemConsole.class);
        IRenderer renderer = new Renderer(mockConsole);
        Canvas canvas = new Canvas(2, 2);
        DrawingArea drawingArea = new DrawingArea(2, 2);
        ArgumentCaptor<String> argscaptor = ArgumentCaptor.forClass(String.class);

        renderer.render(drawingArea, canvas.Draw(drawingArea));

        verify(mockConsole).print(argscaptor.capture());
        List<String> args = argscaptor.getAllValues();
        Assert.assertEquals("----\n|  |\n|  |\n----", args.get(0));

    }

    @Test
    public void should_render_canvas_4_by_4(){
        IConsole mockConsole = mock(SystemConsole.class);
        IRenderer renderer = new Renderer(mockConsole);
        Canvas canvas = new Canvas(4, 4);
        DrawingArea drawingArea = new DrawingArea(4, 4);
        ArgumentCaptor<String> argscaptor = ArgumentCaptor.forClass(String.class);

        renderer.render(drawingArea, canvas.Draw(drawingArea));

        verify(mockConsole).print(argscaptor.capture());
        List<String> args = argscaptor.getAllValues();
        Assert.assertEquals("------\n|    |\n|    |\n|    |\n|    |\n------", args.get(0));

    }


    @Test
    public void should_render_canvas_and_line() throws Exception {
        IConsole mockConsole = mock(SystemConsole.class);
        IRenderer renderer = new Renderer(mockConsole);
        Canvas canvas = new Canvas(4, 4);

        DrawingArea drawingArea = new DrawingArea(4, 4);
        ArgumentCaptor<String> argscaptor = ArgumentCaptor.forClass(String.class);

        List<DrawingPoint> dps = canvas.Draw(drawingArea);
        Line firstLine = new Line(1, 2, 5, 2);
        dps.addAll(firstLine.Draw(drawingArea));
        Line secondLine = new Line(1, 3, 5, 3);
        dps.addAll(secondLine.Draw(drawingArea));
        renderer.render(drawingArea, dps);

        verify(mockConsole).print(argscaptor.capture());
        List<String> args = argscaptor.getAllValues();
        Assert.assertEquals("------\n|    |\n|----|\n|----|\n|    |\n------", args.get(0));

    }
}
