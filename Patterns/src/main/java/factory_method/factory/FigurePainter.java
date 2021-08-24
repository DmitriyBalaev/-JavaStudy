package factory_method.factory;

import factory_method.model.Shape;

public abstract class FigurePainter {

    public void drawShape(){
        Shape shape = createShape();
        shape.draw();
    }

    public abstract Shape createShape();
}
