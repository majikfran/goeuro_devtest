package me.fcbwilliams.goeuro.devtest.util.interfaces;

public interface IObjectConverter<T, U> {
	U convert(T object);
}
