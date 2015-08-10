package me.fcbwilliams.goeuro.devtest.filesystem.interfaces;

import java.io.IOException;
import java.util.List;

/**
 * An interface for all FileObjectWriters
 * 
 * @author Francis
 *
 * @param <T> The type T of the object to be written to file.
 */
public interface IFileObjectWriter<T> {
	/**
	 * Writes the accessible properties of a collection of objects
	 * to a file.
	 * @param objects The objects to be written
	 * @throws IOException
	 */
	void writeData(List<? extends T> objects) throws IOException;
}
