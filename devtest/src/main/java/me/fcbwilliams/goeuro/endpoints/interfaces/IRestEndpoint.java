package me.fcbwilliams.goeuro.endpoints.interfaces;

import java.util.List;

public interface IRestEndpoint<T>  {
	List<? extends T> getData(String parameter);
}
