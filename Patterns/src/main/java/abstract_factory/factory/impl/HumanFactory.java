package abstract_factory.factory.impl;

import abstract_factory.factory.Factory;
import abstract_factory.model.Archer;
import abstract_factory.model.Mage;
import abstract_factory.model.Warrior;
import abstract_factory.model.impl.human.HumanArcher;
import abstract_factory.model.impl.human.HumanMage;
import abstract_factory.model.impl.human.HumanWarrior;

public class HumanFactory implements Factory {
    @Override
    public Mage getMage() {
        return new HumanMage();
    }

    @Override
    public Archer getArcher() {
        return new HumanArcher();
    }

    @Override
    public Warrior getWarrior() {
        return new HumanWarrior();
    }
}
