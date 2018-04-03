package Canvas.Commands;

import Canvas.Shapes.Shape;

public interface CommandWrapper {
    Boolean isValid(String cmd);
    Shape getShape();
}
