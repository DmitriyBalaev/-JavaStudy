package abstract_factory.model.impl.elf;

import abstract_factory.model.Archer;

public class ElfArcher implements Archer {
    @Override
    public String getName() {
        return "ElfArcherName";
    }
}
