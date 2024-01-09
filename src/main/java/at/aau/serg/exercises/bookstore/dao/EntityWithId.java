package at.aau.serg.exercises.bookstore.dao;

public interface EntityWithId<K> {

    K getId();

    void setId(K id);
}
