package factory_method;

import factory_method.factory.FigurePainter;
import factory_method.factory.SquarePainter;
import factory_method.factory.TrianglePainter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<FigurePainter> factories = new ArrayList<>();
        factories.add(new SquarePainter());
        factories.add(new TrianglePainter());

        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            FigurePainter painter = factories.get(random.nextInt(2));
            painter.drawShape();
        }
    }
}
