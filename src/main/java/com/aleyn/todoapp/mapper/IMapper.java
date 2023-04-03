package com.aleyn.todoapp.mapper;

/**
 * Generic interface to map Entities to DTOS or DTOS to Entities.
 * @param <I> Input
 * @param <O> Output
 */
public interface IMapper <I, O> {
    public O map(I in);
}
