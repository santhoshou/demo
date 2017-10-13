package com.example.demo.common;

public class DemoException extends Exception {
	private static final long serialVersionUID = -2993851056303264697L;

	public DemoException(String string) {
		super(string);
	}

	public DemoException(Exception e) {
		super(e);
	}
}
