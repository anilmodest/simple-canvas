package Canvas;

import Canvas.Commands.CanvasCommandWrapper;
import Canvas.Commands.CommandWrapper;
import Canvas.Exceptions.ExceptionMessages;
import Canvas.Renderer.Console;
import Canvas.Renderer.TextRenderer;
import Canvas.Renderer.SystemConsole;
import Canvas.Shapes.Shape;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;


public class CommandManagerTest {
    @Test
    public void execute_command() throws Exception {
       CanvasCommandWrapper mockCommand = mock(CanvasCommandWrapper.class);
       Shape mockShape = mock(Shape.class);
       Console mockConsole = mock(Console.class);
       CommandManager cmdMgr = new CommandManager(new TextRenderer(mockConsole));
       when(mockCommand.getShape()).thenReturn(mockShape);
       when(mockCommand.getLength()).thenReturn(2);
       when(mockCommand.getHeight()).thenReturn(2);
       cmdMgr.execute(mockCommand);
       verify(mockShape, times(1)).Draw(Mockito.any());
    }

    @Test
    public void should_give_error_message_shape_drawn_before_canvas() throws Exception {

        CommandWrapper mockCommand = mock(CommandWrapper.class);
        Shape mockShape = mock(Shape.class);
        CommandManager cmdMgr = new CommandManager(new TextRenderer(new SystemConsole()));
        when(mockCommand.getShape()).thenReturn(mockShape);
        String errorMessage = cmdMgr.execute(mockCommand);
        Assert.assertEquals(ExceptionMessages.CANVAS_NOT_DRAWN, errorMessage);
    }
}
