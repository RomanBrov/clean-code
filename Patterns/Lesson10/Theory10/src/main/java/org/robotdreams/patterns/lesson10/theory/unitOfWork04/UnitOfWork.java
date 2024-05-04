package org.robotdreams.patterns.lesson10.theory.unitOfWork04;

import org.robotdreams.patterns.lesson10.theory.auxiliary.*;
import java.util.List;

public class UnitOfWork implements ICommandLight {
    private final List<ICommandLight> commands;

    public UnitOfWork(List<ICommandLight> commands) {
        if (commands == null) throw new IllegalArgumentException("commands cannot be null");
        this.commands = commands;
    }

    @Override
    public void execute() {
        System.out.printf("Executing batch of %d commands%n", commands.size());
        for (ICommandLight command : commands) {
            command.execute();
        }
    }
}
