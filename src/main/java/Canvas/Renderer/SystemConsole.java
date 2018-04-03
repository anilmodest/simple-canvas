package Canvas.Renderer;

public class SystemConsole implements Console {
    @Override
    public void print(String output) {
        System.out.println(output);
    }
}
