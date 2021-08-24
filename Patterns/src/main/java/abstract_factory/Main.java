package abstract_factory;

import abstract_factory.factory.impl.ElfFactory;
import abstract_factory.factory.impl.HumanFactory;

public class Main {
    public static void main(String[] args) {
        Application application = new Application(new ElfFactory());
        print(application);

        System.out.println("===========");

        application = new Application(new HumanFactory());
        print(application);
    }

    static void print(Application app){
        for (String s : app.getNames().keySet()){
            System.out.println(s + " = " + app.getNames().get(s));
        }
    }
}
