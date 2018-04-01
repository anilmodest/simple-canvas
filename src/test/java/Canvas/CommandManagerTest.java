package Canvas;

import Canvas.Commands.CanvasCommand;
import Canvas.Commands.ICommand;
import Canvas.Commands.UndoCommand;
import Canvas.Exceptions.UndoException;
import Canvas.Renderer.IConsole;
import Canvas.Renderer.Renderer;
import Canvas.Renderer.SystemConsole;
import Canvas.Shapes.IShape;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.mockito.Mockito.*;


public class CommandManagerTest {
    @Test
    public void execute_command() throws Exception, UndoException {
       CanvasCommand mockCommand = mock(CanvasCommand.class);
       IShape mockShape = mock(IShape.class);
       IConsole mockConsole = mock(IConsole.class);
       CommandManager cmdMgr = new CommandManager(new Renderer(mockConsole));
       when(mockCommand.getShape()).thenReturn(mockShape);
       when(mockCommand.getLength()).thenReturn(2);
       when(mockCommand.getHeight()).thenReturn(2);
       cmdMgr.execute(mockCommand);
       verify(mockShape, times(1)).Draw(Mockito.any());
    }

    @Test(expected = Exception.class)
    public void should_throw_exception_shape_drawn_before_canvas() throws Exception, UndoException {

        ICommand mockCommand = mock(ICommand.class);
        IShape mockShape = mock(IShape.class);
        CommandManager cmdMgr = new CommandManager(new Renderer(new SystemConsole()));
        when(mockCommand.getShape()).thenReturn(mockShape);
        cmdMgr.execute(mockCommand);
        verify(mockShape, times(1)).Draw(Mockito.any());
    }
}
