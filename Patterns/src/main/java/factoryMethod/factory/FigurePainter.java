package factoryMethod.factory;

import factoryMethod.model.Shape;

public abstract class FigurePainter {

    public void drawShape(){
        Shape shape = createShape();
        shape.draw();
    }

    public abstract Shape createShape();
}
