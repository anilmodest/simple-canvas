package Canvas;

import Canvas.Commands.CanvasCommandWrapper;
import Canvas.Commands.CommandWrapper;
import Canvas.Exceptions.ExceptionMessages;
import Canvas.Renderer.Renderer;

public class CommandManager {
    private DrawingBoard drawingBoard;
    private Renderer renderer;

    public CommandManager(Renderer renderer){
        this.renderer = renderer;
    }

    public String execute(CommandWrapper command) {
        String errorMessage = "";
        CanvasCommandWrapper canvasCommand = command instanceof CanvasCommandWrapper ? (CanvasCommandWrapper) command: null;

        if(command instanceof CanvasCommandWrapper) {
             canvasCommand = (CanvasCommandWrapper)command;
        }


        if(canvasCommand != null) {
            this.drawingBoard = new DrawingBoard(canvasCommand.getLength(), canvasCommand.getHeight());
        }


        if (this.drawingBoard == null) {
            errorMessage = ExceptionMessages.CANVAS_NOT_DRAWN;
        }
        else {
            errorMessage = command.getShape().Draw(this.drawingBoard);
            this.renderer.render(this.drawingBoard.toString());
        }
        return errorMessage;
    }

}
