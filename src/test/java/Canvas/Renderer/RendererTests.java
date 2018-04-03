package Canvas.Renderer;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class RendererTests {

    @Test
    public void should_render_shape(){
        Console mockConsole = mock(SystemConsole.class);
        Renderer renderer = new TextRenderer(mockConsole);
        ArgumentCaptor<String> argscaptor = ArgumentCaptor.forClass(String.class);

        renderer.render("hello");
        verify(mockConsole).print(argscaptor.capture());

        Assert.assertEquals("hello", argscaptor.getValue());

    }
}
