package me.fcbwilliams.goeuro.endpoints.interfaces;

import java.util.List;

public interface IEndpoint<T>  {
	T getById(int id);
	List<? extends T> getSuggestions(String name);
}