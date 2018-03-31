package Canvas.Renderer;

import Canvas.DrawingArea;
import Canvas.DrawingPoint;

import java.util.List;

public interface IRenderer {

    void render(DrawingArea drawingArea, List<DrawingPoint> pointsToDraw);
}
