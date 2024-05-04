package org.robotdreams.patterns.lesson10.theory.dynamic03;

import org.robotdreams.patterns.lesson10.theory.models.*;
import org.robotdreams.patterns.lesson10.theory.auxiliary.*;

public class DynamicCommands {
    // this should be initialized via DI
    private final ICommandFactory commandFactory = new CommandFactory();

    private final TextEditorViewModel viewModel = new TextEditorViewModel() {
        // imitate actual items edited by user
        {
            setSaveAll(false);
            setFontSizePt("12pt");
            setRows(3);
            setColumns(4);
            setTableType("Basic");
        }
    };

    public void start() {
        System.out.println("Starting " + DynamicCommands.class.getSimpleName());

        processButtonClick_optionNo2(new Button(ButtonNames.Save));
        processButtonClick_optionNo2(new Button(ButtonNames.Load));
        processButtonClick_optionNo2(new Button(ButtonNames.ChangeFont));
        processButtonClick_optionNo2(new Button(ButtonNames.InsertTable));

        System.out.println();
    }

    private void processButtonClick_optionNo2(Button sender) {
        commandFactory.create(sender, viewModel).execute();
    }
}

