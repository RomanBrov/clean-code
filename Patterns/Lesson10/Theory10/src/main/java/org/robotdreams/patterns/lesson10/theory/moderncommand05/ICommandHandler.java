package org.robotdreams.patterns.lesson10.theory.moderncommand05;

public interface ICommandHandler<TCommand> {
    void handle(TCommand command);
}
