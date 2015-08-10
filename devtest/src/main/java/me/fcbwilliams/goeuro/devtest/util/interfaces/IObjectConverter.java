package me.fcbwilliams.goeuro.devtest.util.interfaces;

/**
 * Generic interface for object converters
 * @author Francis
 *
 * @param <T> The object type to convert from.
 * @param <U> The object type to convert to.
 */
public interface IObjectConverter<T, U> {
	/**
	 * Converts an object.
	 * 
	 * @param object The object to be converted
	 * @return The converted object
	 */
	U convert(T object);
}
