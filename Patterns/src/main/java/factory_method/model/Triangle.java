package factory_method.model;

public class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawn triangle");
    }
}
