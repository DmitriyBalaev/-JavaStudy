package abstract_factory.model.impl.human;

import abstract_factory.model.Archer;

public class HumanArcher implements Archer {
    @Override
    public String getName() {
        return "HumanArcherName";
    }
}
