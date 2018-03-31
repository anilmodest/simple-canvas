package Canvas.Renderer;

import Canvas.DrawingArea;
import Canvas.DrawingPoint;

import java.util.List;
import java.util.Optional;

public class Renderer implements IRenderer {
    private IConsole console;

    public Renderer(IConsole console) {

        this.console = console;
    }

    @Override
    public void render(DrawingArea drawingArea, List<DrawingPoint> pointsToDraw) {
        StringBuilder sb = new StringBuilder();
        for(int y =0 ;y<drawingArea.getHeight() + 2; y++) {

            if(sb.length() != 0) {
                sb.append("\n");
            }
            for(int x =0; x<drawingArea.getLength() + 2; x++) {
                int finalY = y;
                int finalX = x;

                Optional<DrawingPoint> optionalMatch = pointsToDraw.stream().filter(p -> p.getPoint().x == finalX && p.getPoint().y == finalY).findFirst();
                if(optionalMatch.isPresent()) {
                    sb.append(optionalMatch.get().getDrawingChar());
                }
                else {
                    sb.append(' ');
                }

            }
        }

        this.console.print(sb.toString());
    }

}
