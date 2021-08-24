package abstract_factory;

import abstract_factory.factory.Factory;
import abstract_factory.model.Archer;
import abstract_factory.model.Mage;
import abstract_factory.model.Warrior;

import java.util.HashMap;
import java.util.Map;

public class Application {
    private Archer archer;
    private Mage mage;
    private Warrior warrior;

    public Application(Factory factory) {
        this.archer = factory.getArcher();
        this.mage = factory.getMage();
        this.warrior = factory.getWarrior();
    }

    public Map<String, String> getNames(){
        Map<String, String> names = new HashMap<>();
        names.put("[Archer]", archer.getName());
        names.put("[Warrior]", warrior.getName());
        names.put("[Mage]", mage.getName());
        return names;
    }
}
