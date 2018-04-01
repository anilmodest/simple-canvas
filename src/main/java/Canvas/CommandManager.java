package Canvas;

import Canvas.Commands.CanvasCommand;
import Canvas.Commands.ICommand;
import Canvas.Commands.RedoCommand;
import Canvas.Commands.UndoCommand;
import Canvas.Exceptions.UndoException;
import Canvas.Renderer.IRenderer;

import java.util.*;

public class CommandManager {
    private DrawingBoard drawingBoard;
    private IRenderer renderer;

    public CommandManager(IRenderer renderer){
        this.renderer = renderer;
    }

    public void execute(ICommand command) throws Exception {
        CanvasCommand canvasCommand = command instanceof CanvasCommand ? (CanvasCommand) command: null;

        if(command instanceof CanvasCommand) {
             canvasCommand = (CanvasCommand)command;
        }


        if(canvasCommand != null) {
            this.drawingBoard = new DrawingBoard(canvasCommand.getLength(), canvasCommand.getHeight());
        }


        if (this.drawingBoard == null) {
            throw new Exception("First draw canvas");
        }

        command.getShape().Draw(this.drawingBoard);
        this.renderer.render(this.drawingBoard.toString());

    }

}
