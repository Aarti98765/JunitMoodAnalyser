package com.bridglabz.moodanalysers.factory;

import com.bridglabz.moodanalysers.MoodAnalyser;
import com.bridglabz.moodanalysers.exceptions.MoodAnalyserException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {

    public static Constructor getConstructor(String className, Class... parameter) throws MoodAnalyserException {
        try {
            Class<?> moodAnalyserClass = Class.forName(className);
            return  moodAnalyserClass.getConstructor(parameter);
        } catch (ClassNotFoundException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.CLASSNOTFOUND,"Class not found");
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.NOSUCHMETHOD,"Method not found");
        }
    }

    public static MoodAnalyser getMoodAnalyserObject(Constructor constructor,Object... objects) throws  MoodAnalyserException {
        try {
            return (MoodAnalyser) constructor.newInstance(objects);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}

