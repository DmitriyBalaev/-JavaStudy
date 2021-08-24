package abstract_factory.factory;

import abstract_factory.model.Archer;
import abstract_factory.model.Mage;
import abstract_factory.model.Warrior;

public interface Factory {

    Mage getMage();

    Archer getArcher();

    Warrior getWarrior();
}
