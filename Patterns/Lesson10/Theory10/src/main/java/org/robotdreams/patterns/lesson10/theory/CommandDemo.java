package org.robotdreams.patterns.lesson10.theory;

import org.robotdreams.patterns.lesson10.theory.classic01.ClassicCommands;
import org.robotdreams.patterns.lesson10.theory.dynamic03.DynamicCommands;
import org.robotdreams.patterns.lesson10.theory.full02.FullCommands;
import org.robotdreams.patterns.lesson10.theory.moderncommand05.ModernCommands;
import org.robotdreams.patterns.lesson10.theory.moderqueries06.ModernQueries;
import org.robotdreams.patterns.lesson10.theory.unitOfWork04.UnitOfWorkCommand;

public class CommandDemo {
    public void start() {
        new ClassicCommands().start();
        new FullCommands().start();
        new DynamicCommands().start();
        new UnitOfWorkCommand().start();
        new ModernCommands().start();
        new ModernQueries().start();
    }
}
