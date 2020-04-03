package com.bridglabz.moodanalysers.factory;

import com.bridglabz.moodanalysers.MoodAnalyser;
import com.bridglabz.moodanalysers.exceptions.MoodAnalyserException;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
public class MoodAnalyserFactory {
    MoodAnalyser moodAnalyser;
    public static MoodAnalyser getMoodAnalyserObject() {
        try {
            Constructor constructor = Class.forName("com.bridglabz.moodanalysers.MoodAnalyser")
                    .getConstructor(String.class);
            Object reflectionObject = constructor.newInstance("I am in Sad Mood");
            MoodAnalyser moodAnalysers = (MoodAnalyser) reflectionObject;
            MoodAnalyser realMoodObject = new MoodAnalyser("I am in Sad Mood");
            boolean result = realMoodObject.equals(moodAnalysers);
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

}

