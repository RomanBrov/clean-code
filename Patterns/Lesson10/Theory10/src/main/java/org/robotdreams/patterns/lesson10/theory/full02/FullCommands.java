package org.robotdreams.patterns.lesson10.theory.full02;

import org.robotdreams.patterns.lesson10.theory.auxiliary.*;

public class FullCommands {
    private ICommandFull lastCommand = new EmptyCommandFull();

    public void start() {
        System.out.printf("Starting %s%n", FullCommands.class.getSimpleName());

        processButtonClick_optionNo1(new Button(ButtonNames.ChangeFont));
        processButtonClick_optionNo1(new Button(ButtonNames.Undo));
        processButtonClick_optionNo1(new Button(ButtonNames.Redo));

        System.out.println();
    }

    private void processButtonClick_optionNo1(Button sender) {
        switch (sender.getName()) {
            case ButtonNames.ChangeFont:
                lastCommand = new ChangeFontFull(lastCommand, "12pt", "14pt");
                lastCommand.execute();
                break;
            case ButtonNames.Undo:
                if (!lastCommand.isActive()) return;
                lastCommand.undo();
                lastCommand = lastCommand.getPrev();
                break;
            case ButtonNames.Redo:
                lastCommand.redo();
                lastCommand = lastCommand.getNext();
                break;
        }
    }
}

