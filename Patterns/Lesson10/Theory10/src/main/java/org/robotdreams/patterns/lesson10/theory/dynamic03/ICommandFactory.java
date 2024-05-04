package org.robotdreams.patterns.lesson10.theory.dynamic03;

import org.robotdreams.patterns.lesson10.theory.auxiliary.*;
import org.robotdreams.patterns.lesson10.theory.models.*;

public interface ICommandFactory {
    ICommandLight create(Button sender, TextEditorViewModel viewModel);
}
