package org.robotdreams.patterns.lesson10.theory.full02;

public class ChangeFontFull extends BaseCommandFull {
    private final String fontSizeOld;
    private final String fontSizeNew;

    public ChangeFontFull(ICommandFull prevCommand, String fontSizeOld, String fontSizeNew) {
        super(prevCommand);
        this.fontSizeOld = fontSizeOld;
        this.fontSizeNew = fontSizeNew;
    }

    @Override
    public void execute() {
        System.out.printf("Executing %s from %s to %s%n", ChangeFontFull.class.getSimpleName(), fontSizeOld, fontSizeNew);
    }

    @Override
    public void undo() {
        System.out.printf("Undoing %s from %s to %s%n", ChangeFontFull.class.getSimpleName(), fontSizeNew, fontSizeOld);
    }

    @Override
    public void redo() {
        System.out.printf("Redoing %s from %s to %s%n", ChangeFontFull.class.getSimpleName(), fontSizeOld, fontSizeNew);
    }

    @Override
    public String getLocalizationKey() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isActive() {
        return true;
    }
}
