package abstract_factory.model.impl.elf;

import abstract_factory.model.Warrior;

public class ElfWarrior implements Warrior {
    @Override
    public String getName() {
        return "ElfWarriorName";
    }
}
