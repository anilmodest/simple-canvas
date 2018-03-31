package Canvas;

import Canvas.Commands.CanvasCommand;
import Canvas.Commands.ICommand;
import Canvas.Commands.RedoCommand;
import Canvas.Commands.UndoCommand;
import Canvas.Exceptions.UndoException;
import Canvas.Renderer.IRenderer;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class CommandManager {
    private ICommand command;
    private DrawingArea drawingArea;
    private IRenderer renderer;
    private Stack<ICommand> commandToExecute;
    private Stack<ICommand> undoCommands;

    public CommandManager(IRenderer renderer){

        this.renderer = renderer;
        this.commandToExecute = new Stack<>();
        this.undoCommands = new Stack<>();
    }

    public void execute() throws Exception, UndoException {

        CanvasCommand canvasCommand = this.command instanceof CanvasCommand ? (CanvasCommand) this.command: null;
        UndoCommand undoCommand = this.command instanceof UndoCommand ? (UndoCommand) this.command: null;
        RedoCommand redoCommand = this.command instanceof RedoCommand ? (RedoCommand) this.command: null;

        if(this.command instanceof CanvasCommand) {
             canvasCommand = (CanvasCommand)this.command;
        }


        if(canvasCommand != null) {
            this.drawingArea = new DrawingArea(canvasCommand.getLength(), canvasCommand.getHeight());
            this.commandToExecute = new Stack<>();
        }

        if(undoCommand != null) {
            if(this.commandToExecute.empty()) {
                throw new UndoException("nothing to undo");
            }
            this.undoCommands.push(this.commandToExecute.pop());
        }
        else if(redoCommand != null) {
            if(!this.commandToExecute.empty()) {
                this.commandToExecute.push(this.undoCommands.pop());
            }
        }
        else {
            if (this.drawingArea == null) {
                throw new Exception("First draw canvas");
            }

            try {
                List<DrawingPoint> dps = this.commandToExecute.stream().flatMap(x -> getShapeCoordinates(x).stream()).collect(Collectors.toList());
                dps.addAll(this.command.getShape().Draw(this.drawingArea));
                this.renderer.render(this.drawingArea, dps);
                commandToExecute.push(this.command);
            }
            catch (RuntimeException e) {
                throw e;
            }


        }
    }

    private List<DrawingPoint> getShapeCoordinates(ICommand cmd) {
        try{
            return cmd.getShape().Draw(this.drawingArea);
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public void setCommand(ICommand command) {
        this.command = command;
    }
}
