package com.vehicle;

@SuppressWarnings("serial")
public class PollutionLevelExceededException extends Exception{
	public PollutionLevelExceededException(String message) {
		super(message);
	}
}
