package at.aau.serg.exercises.bookstore.dao.impl;

import at.aau.serg.exercises.bookstore.dao.Dao;
import at.aau.serg.exercises.bookstore.dao.EntityWithId;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class ListDao<T extends EntityWithId<Long>> implements Dao<Long, T> {
    protected List<T> list = new ArrayList<>();
    protected Long currentId;

    public List<T> findAll() {
        return this.list;
    }

    public T findOne(Long id) {
        for (T p : this.list) {
            if (Objects.equals(p.getId(), id)) {
                return p;
            }
        }
        return null;
    }

    public T insert(T element) {
        element.setId(currentId++);
        this.list.add(element);
        return element;
    }

    public void delete(Long id) {
        T element = null;
        for (T p : this.list) {
            if (Objects.equals(p.getId(), id)) {
                element = p;
                break;
            }
        }
        if (element != null) {
            this.list.remove(element);
        }
    }

    public T update(T element) {
        delete(element.getId());
        return insert(element);
    }
}
