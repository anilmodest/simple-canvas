package Canvas.Renderer;

import Canvas.DrawingBoard;
import Canvas.DrawingPoint;

import java.util.List;
import java.util.Optional;

public class Renderer implements IRenderer {
    private IConsole console;

    public Renderer(IConsole console) {

        this.console = console;
    }

    @Override
    public void render(String printText) {
        this.console.print(printText);
    }

}
