package Canvas;

import Canvas.Commands.CanvasCommand;
import Canvas.Commands.ICommand;
import Canvas.Commands.RedoCommand;
import Canvas.Commands.UndoCommand;
import Canvas.Exceptions.UndoException;
import Canvas.Renderer.IRenderer;

import java.util.*;

public class CommandManager {
    private ICommand command;
    private DrawingBoard drawingBoard;
    private IRenderer renderer;
    private Queue<ICommand> commandToExecute;
    private Stack<ICommand> undoCommands;

    public CommandManager(IRenderer renderer){

        this.renderer = renderer;
        this.commandToExecute = new LinkedList<>();
        this.undoCommands = new Stack<>();
    }

    public void execute() throws Exception, UndoException {
        List<DrawingPoint> shapePoints = new ArrayList<>();
        CanvasCommand canvasCommand = this.command instanceof CanvasCommand ? (CanvasCommand) this.command: null;
        UndoCommand undoCommand = this.command instanceof UndoCommand ? (UndoCommand) this.command: null;
        RedoCommand redoCommand = this.command instanceof RedoCommand ? (RedoCommand) this.command: null;

        if(this.command instanceof CanvasCommand) {
             canvasCommand = (CanvasCommand)this.command;
        }


        if(canvasCommand != null) {
            this.drawingBoard = new DrawingBoard(canvasCommand.getLength(), canvasCommand.getHeight());
            this.commandToExecute = new LinkedList<>();
            this.undoCommands = new Stack<>();
        }

        if(undoCommand != null) {
            if(this.commandToExecute.isEmpty()) {
                throw new UndoException("nothing to undo");
            }
            this.undoCommands.push(this.commandToExecute.element());
        }
        else if(redoCommand != null) {
            if(!this.commandToExecute.isEmpty()) {
                this.commandToExecute.add(this.undoCommands.pop());
            }
        }
        else {
            commandToExecute.add(this.command);
        }

        if (this.drawingBoard == null) {
            throw new Exception("First draw canvas");
        }

            command.getShape().Draw(this.drawingBoard);
            this.renderer.render(this.drawingBoard.toString());

    }



    public void setCommand(ICommand command) {
        this.command = command;
    }
}
