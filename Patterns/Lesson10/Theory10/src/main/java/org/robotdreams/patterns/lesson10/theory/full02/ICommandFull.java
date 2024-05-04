package org.robotdreams.patterns.lesson10.theory.full02;

public interface ICommandFull {
    void execute();
    void undo();
    void redo();
    String getLocalizationKey();
    ICommandFull getNext();
    ICommandFull getPrev();
    void setCaller(String caller);
    boolean isActive();
}
