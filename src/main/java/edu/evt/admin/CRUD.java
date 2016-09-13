package edu.evt.admin;

import java.util.UUID;

/**
 * Created by Wheeler on 9/12/2016.
 */
public interface CRUD<T> {
    T get(UUID id);
    boolean save(T item);
}
