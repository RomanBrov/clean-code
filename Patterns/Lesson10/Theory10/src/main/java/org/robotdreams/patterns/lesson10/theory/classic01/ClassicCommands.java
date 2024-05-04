package org.robotdreams.patterns.lesson10.theory.classic01;

import org.robotdreams.patterns.lesson10.theory.auxiliary.*;
import org.robotdreams.patterns.lesson10.theory.models.TextEditorViewModel;

public class ClassicCommands {
    private final TextEditorViewModel viewModel = new TextEditorViewModel();

    public ClassicCommands() {
        viewModel.setSaveAll(false);
        viewModel.setFontSizePt("12pt");
        viewModel.setRows(3);
        viewModel.setColumns(4);
        viewModel.setTableType("Basic");
    }

    public void start() {
        System.out.printf("Starting %s%n", ClassicCommands.class.getSimpleName());

        processButtonClick_optionNo1(new Button(ButtonNames.Save));
        processButtonClick_optionNo1(new Button(ButtonNames.Load));
        processButtonClick_optionNo1(new Button(ButtonNames.ChangeFont));
        processButtonClick_optionNo1(new Button(ButtonNames.InsertTable));

        System.out.println();
    }

    private void processButtonClick_optionNo1(Button sender) {
        switch (sender.getName()) {
            case ButtonNames.Save:
                new SaveCommand(viewModel.isSaveAll()).execute();
                break;
            case ButtonNames.Load:
                new LoadCommand().execute();
                break;
            case ButtonNames.ChangeFont:
                new ChangeFont(viewModel.getFontSizePt()).execute();
                break;
            case ButtonNames.InsertTable:
                new InsertTable(viewModel.getRows(), viewModel.getColumns(), viewModel.getTableType()).execute();
                break;
        }
    }
}

