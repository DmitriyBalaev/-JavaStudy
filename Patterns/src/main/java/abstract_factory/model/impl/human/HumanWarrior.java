package abstract_factory.model.impl.human;

import abstract_factory.model.Warrior;

public class HumanWarrior implements Warrior {
    @Override
    public String getName() {
        return "HumanWarriorName";
    }
}
