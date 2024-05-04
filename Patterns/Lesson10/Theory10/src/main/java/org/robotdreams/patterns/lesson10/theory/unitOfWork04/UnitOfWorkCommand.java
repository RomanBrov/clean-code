package org.robotdreams.patterns.lesson10.theory.unitOfWork04;

import org.robotdreams.patterns.lesson10.theory.auxiliary.*;
import org.robotdreams.patterns.lesson10.theory.classic01.*;

import java.util.ArrayList;
import java.util.List;

public class UnitOfWorkCommand {
    public void start() {
        System.out.println("Starting " + UnitOfWorkCommand.class.getSimpleName());

        List<ICommandLight> commandList = new ArrayList<>();
        commandList.add(new SaveCommand(false));
        commandList.add(new SaveCommand(true));
        commandList.add(new SaveCommand(false));

        new UnitOfWork(commandList).execute();

        System.out.println();
    }
}

