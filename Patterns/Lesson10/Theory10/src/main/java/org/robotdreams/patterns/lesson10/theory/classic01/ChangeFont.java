package org.robotdreams.patterns.lesson10.theory.classic01;

import org.robotdreams.patterns.lesson10.theory.auxiliary.ICommandLight;

public class ChangeFont implements ICommandLight {
    private final String fontSizePt;

    public ChangeFont(String fontSizePt) {
        this.fontSizePt = fontSizePt;
    }

    @Override
    public void execute() {
        System.out.printf("Executing %s with size=%s%n", ChangeFont.class.getSimpleName(), fontSizePt);
    }
}
