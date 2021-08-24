package factory_method.factory;

import factory_method.model.Shape;
import factory_method.model.Square;

public class SquarePainter extends FigurePainter {
    @Override
    public Shape createShape() {
        return new Square();
    }
}
