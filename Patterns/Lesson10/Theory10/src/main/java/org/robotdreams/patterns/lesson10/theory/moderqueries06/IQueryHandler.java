package org.robotdreams.patterns.lesson10.theory.moderqueries06;

public interface IQueryHandler<TQuery, TResult> {
    TResult handle(TQuery query);
}
