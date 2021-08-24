package factory_method.factory;

import factory_method.model.Shape;
import factory_method.model.Triangle;

public class TrianglePainter extends FigurePainter {
    @Override
    public Shape createShape() {
        return new Triangle();
    }
}
