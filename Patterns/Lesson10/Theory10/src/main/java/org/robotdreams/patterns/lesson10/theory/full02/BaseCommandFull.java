package org.robotdreams.patterns.lesson10.theory.full02;

public abstract class BaseCommandFull implements ICommandFull {
    protected String caller;
    protected ICommandFull nextCommand;
    protected ICommandFull prevCommand;

    protected BaseCommandFull(ICommandFull prevCommand) {
        this.prevCommand = prevCommand;
        if (this.prevCommand instanceof BaseCommandFull) {
            ((BaseCommandFull) this.prevCommand).nextCommand = this;
        }
    }

    @Override
    public abstract void execute();

    @Override
    public abstract void undo();

    @Override
    public abstract void redo();

    @Override
    public abstract String getLocalizationKey();

    @Override
    public ICommandFull getNext() {
        return nextCommand;
    }

    @Override
    public ICommandFull getPrev() {
        return prevCommand;
    }

    @Override
    public void setCaller(String caller) {
        this.caller = caller;
    }
}
