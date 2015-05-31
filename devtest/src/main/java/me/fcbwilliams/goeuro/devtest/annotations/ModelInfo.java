package me.fcbwilliams.goeuro.devtest.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ModelInfo {
	public String name();

}
