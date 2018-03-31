package Canvas.Commands;

import Canvas.Shapes.IShape;

public interface ICommand {
    Boolean isValid(String cmd);
    IShape getShape();
}
