package Canvas.Renderer;

public class SystemConsole implements IConsole {
    @Override
    public void print(String output) {
        System.out.println(output);
    }
}
