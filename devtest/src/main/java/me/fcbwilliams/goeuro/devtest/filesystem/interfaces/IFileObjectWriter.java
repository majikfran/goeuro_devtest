package me.fcbwilliams.goeuro.devtest.filesystem.interfaces;

import java.io.IOException;

public interface IFileObjectWriter<T> {
	void writeData(T[] objects, String path) throws IOException;
}
