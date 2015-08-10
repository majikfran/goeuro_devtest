package me.fcbwilliams.goeuro.endpoints.interfaces;

import java.util.List;

/**
 * Interface for REST enpoints
 * @author Francis
 *
 * @param <T> The domain object type expected
 */
public interface IRestEndpoint<T>  {
	List<? extends T> getData(String parameter);
}
