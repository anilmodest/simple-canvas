package Canvas.Renderer;

import Canvas.DrawingPoint;
import Canvas.DrawingBoard;
import Canvas.Shapes.Canvas;
import Canvas.Shapes.Line;
import Canvas.Shapes.Rectangle;
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
        ArgumentCaptor<String> argscaptor = ArgumentCaptor.forClass(String.class);

        renderer.render("hello");
        verify(mockConsole).print(argscaptor.capture());

        Assert.assertEquals("hello", argscaptor.getValue());

    }
}
