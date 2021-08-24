package abstract_factory.model.impl.human;

import abstract_factory.model.Mage;

public class HumanMage implements Mage {
    @Override
    public String getName() {
        return "HumanMageName";
    }
}
