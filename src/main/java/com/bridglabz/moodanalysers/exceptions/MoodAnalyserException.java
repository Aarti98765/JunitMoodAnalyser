package com.bridglabz.moodanalysers.exceptions;

public class MoodAnalyserException extends Exception {

    public enum ExceptionType {
        EMTY, NULL, CLASSNOTFOUND, NOSUCHMETHOD, NOSUCHFIELD, ILLEGALACCESSEXCEPTION ;
    }
    public ExceptionType type;
    public MoodAnalyserException(ExceptionType classnotfound, String message) {
        super(message);
    }
}