package org.robotdreams.patterns.lesson10.theory.full02;

public class EmptyCommandFull extends BaseCommandFull {
    public EmptyCommandFull() {
        super(null);
    }

    @Override
    public void execute() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void undo() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void redo() {
        nextCommand.redo();
    }

    @Override
    public String getLocalizationKey() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isActive() {
        return false;
    }
}
