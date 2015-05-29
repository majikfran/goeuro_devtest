package me.fcbwilliams.goeuro.repositories.interfaces;

public interface IRepository<T>  {
	T getById(int id);
	T getByName(String name);
	void create(T entity);
	void delete(T entity);
	void update(T entity);
}
