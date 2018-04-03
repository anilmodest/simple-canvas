package Canvas.Renderer;

public class TextRenderer implements Renderer {
    private Console console;

    public TextRenderer(Console console) {

        this.console = console;
    }

    @Override
    public void render(String printText) {
        this.console.print(printText);
    }

}
