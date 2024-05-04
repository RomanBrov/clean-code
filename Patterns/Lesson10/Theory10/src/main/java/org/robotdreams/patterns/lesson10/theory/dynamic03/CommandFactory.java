package org.robotdreams.patterns.lesson10.theory.dynamic03;

import org.robotdreams.patterns.lesson10.theory.auxiliary.*;
import org.robotdreams.patterns.lesson10.theory.classic01.*;
import org.robotdreams.patterns.lesson10.theory.models.*;

public class CommandFactory implements ICommandFactory {
    @Override
    public ICommandLight create(Button sender, TextEditorViewModel viewModel) {
        switch (sender.getName()) {
            case ButtonNames.Save:
                return new SaveCommand(viewModel.isSaveAll());
            case ButtonNames.Load:
                return new LoadCommand();
            case ButtonNames.ChangeFont:
                return new ChangeFont(viewModel.getFontSizePt());
            case ButtonNames.InsertTable:
                return new InsertTable(viewModel.getRows(), viewModel.getColumns(), viewModel.getTableType());
            default:
                throw new UnsupportedOperationException();
        }
    }
}
