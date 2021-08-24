package abstract_factory.factory.impl;

import abstract_factory.factory.Factory;
import abstract_factory.model.Archer;
import abstract_factory.model.Mage;
import abstract_factory.model.Warrior;
import abstract_factory.model.impl.elf.ElfArcher;
import abstract_factory.model.impl.elf.ElfMage;
import abstract_factory.model.impl.elf.ElfWarrior;

public class ElfFactory implements Factory {
    @Override
    public Mage getMage() {
        return new ElfMage();
    }

    @Override
    public Archer getArcher() {
        return new ElfArcher();
    }

    @Override
    public Warrior getWarrior() {
        return new ElfWarrior();
    }
}
