package Canvas;

import Canvas.Commands.CanvasCommand;
import Canvas.Commands.ICommand;
import Canvas.Commands.UndoCommand;
import Canvas.Exceptions.UndoException;
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
       CommandManager cmdMgr = new CommandManager(new Renderer(new SystemConsole()));
       when(mockCommand.getShape()).thenReturn(mockShape);
       //when(mockCommand instanceof CanvasCommand).thenReturn(true);
       when(mockCommand.getLength()).thenReturn(2);
        when(mockCommand.getHeight()).thenReturn(2);
       cmdMgr.setCommand(mockCommand);
       cmdMgr.execute();
       verify(mockShape, times(1)).Draw(Mockito.any());

    }

    @Test(expected = Exception.class)
    public void should_throw_exception_shape_drawn_before_canvas() throws Exception, UndoException {

        ICommand mockCommand = mock(ICommand.class);
        IShape mockShape = mock(IShape.class);
        CommandManager cmdMgr = new CommandManager(new Renderer(new SystemConsole()));
        when(mockCommand.getShape()).thenReturn(mockShape);
        //when(mockCommand instanceof CanvasCommand).thenReturn(true);
        cmdMgr.setCommand(mockCommand);
        cmdMgr.execute();
        verify(mockShape, times(1)).Draw(Mockito.any());
    }

    @Test(expected = UndoException.class)
    public void nothing_to_undo() throws Exception, UndoException {
        UndoCommand undoCommand = mock(UndoCommand.class);
        IShape mockShape = mock(IShape.class);
        when(mockShape.Draw(Mockito.any())).thenReturn(new ArrayList<>());
        CommandManager cmdMgr = new CommandManager(new Renderer(new SystemConsole()));
        cmdMgr.setCommand(undoCommand);
        cmdMgr.execute();
        verify(mockShape, times(1)).Draw(Mockito.any());
    }
}
