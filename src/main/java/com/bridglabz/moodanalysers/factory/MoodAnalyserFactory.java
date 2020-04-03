package com.bridglabz.moodanalysers.factory;

import com.bridglabz.moodanalysers.MoodAnalyser;
import com.bridglabz.moodanalysers.exceptions.MoodAnalyserException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
public class MoodAnalyserFactory {
    public static MoodAnalyser getMoodAnalyserObject() {
        try {
            Constructor constructor = Class.forName("com.bridglabz.moodanalysers.MoodAnalyser").getConstructor();
            Object reflectionObject = constructor.newInstance();
            return  (MoodAnalyser) reflectionObject;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static MoodAnalyser getMoodAnalyserObject(String className, String... constParam)
            throws MoodAnalyserException {
        try {
            Constructor constructor = Class.forName(className).getConstructor(String.class);
            Object reflectionObject = constructor.newInstance(constParam);
            return  (MoodAnalyser) reflectionObject;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.CLASSNOTFOUND,
                    "Invalid class name");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

}

