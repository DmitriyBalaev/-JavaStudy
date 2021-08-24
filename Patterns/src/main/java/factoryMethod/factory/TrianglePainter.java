package factoryMethod.factory;

import factoryMethod.model.Shape;
import factoryMethod.model.Triangle;

public class TrianglePainter extends FigurePainter {
    @Override
    public Shape createShape() {
        return new Triangle();
    }
}
