package Canvas.Shapes;

import Canvas.DrawingArea;
import Canvas.DrawingPoint;
import Canvas.Exceptions.InvalidLineException;

import java.util.List;

public interface IShape {

    List<DrawingPoint> Draw(DrawingArea drawingArea) throws Exception;
}
