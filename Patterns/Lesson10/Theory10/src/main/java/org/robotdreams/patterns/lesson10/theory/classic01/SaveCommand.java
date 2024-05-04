package org.robotdreams.patterns.lesson10.theory.classic01;

import org.robotdreams.patterns.lesson10.theory.auxiliary.ICommandLight;

public class SaveCommand implements ICommandLight {
    private final boolean saveAll;

    public SaveCommand(boolean saveAll) {
        this.saveAll = saveAll;
    }

    @Override
    public void execute() {
        System.out.printf("Executing %s with SaveAll=%s%n", SaveCommand.class.getSimpleName(), saveAll);
    }
}
