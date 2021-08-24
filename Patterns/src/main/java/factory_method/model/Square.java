package factory_method.model;

public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawn square");
    }
}
