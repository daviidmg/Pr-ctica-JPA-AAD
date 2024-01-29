package DAO;

import java.util.List;

public interface GenericDAO<T> {
	void save(T entity);
	void delete(T entity);
	void update(T entity);
	List<T> findAll();
}
