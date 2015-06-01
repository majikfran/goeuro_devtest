package me.fcbwilliams.goeuro.devtest.filesystem.interfaces;

import java.io.IOException;
import java.util.List;

public interface IFileObjectWriter<T> {
	void writeData(List<? extends T> objects) throws IOException;
}
