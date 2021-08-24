package factoryMethod.factory;

import factoryMethod.model.Shape;
import factoryMethod.model.Square;

public class SquarePainter extends FigurePainter {
    @Override
    public Shape createShape() {
        return new Square();
    }
}
