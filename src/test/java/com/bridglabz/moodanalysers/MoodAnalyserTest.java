package com.bridglabz.moodanalysers;

import com.bridglabz.moodanalysers.exceptions.MoodAnalyserException;
import com.bridglabz.moodanalysers.factory.MoodAnalyserFactory;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserTest {
    @Test
    public void givenSadMessage_whenGetMood_shouldReturnSadMood() {
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        String mood = moodAnalyser.getMood("I am in sad mood");
        Assert.assertEquals("SAD", mood);
    }

    @Test
    public void givenHappyMessage_whenGetMood_shouldReturnHappyMood() {
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        String mood = moodAnalyser.getMood("I am in any mood");
        Assert.assertEquals("HAPPY", mood);
    }

    @Test
    public void givenSadMessageInConstructor_whenGetMood_shouldReturnSadMood() throws MoodAnalyserException {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in sad mood");
        Assert.assertEquals("SAD", moodAnalyser.analyseMood());
    }

    @Test
    public void givenHappyMessageInConstructor_whenGetMood_shouldReturnHappyMood() throws MoodAnalyserException {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in happy mood");
        Assert.assertEquals("HAPPY", moodAnalyser.analyseMood());
    }

    @Test
    public void givenNullMessage_whenAnalyseMood_shouldThrowMoodAnalysisException() {
        try {
            MoodAnalyser moodAnalyser = new MoodAnalyser(null);
            String mood = moodAnalyser.analyseMood();
        }
        catch (MoodAnalyserException moodAnalysisException) {
            Assert.assertEquals("Invalid Message", moodAnalysisException.getMessage());
        }
    }

    @Test
    public void givenEmptyMessage_whenAnalyseMood_shouldThrowMoodAnalysisExceptionEmpty() {
        try {
            MoodAnalyser moodAnalyser = new MoodAnalyser("");
            String mood = moodAnalyser.analyseMood();
        } catch (MoodAnalyserException moodAnalysisException) {
            Assert.assertEquals("Mood should not be empty", moodAnalysisException.getMessage());
        }
    }

    @Test
    public void givenObject_WhenEquals_shouldReturnObject() throws MoodAnalyserException {
        try {
                Constructor constructor = Class.forName("com.bridglabz.moodanalyser.MoodAnalyser")
                        .getConstructor(String.class);
                Object reflectionObject = constructor.newInstance("I am in Sad Mood");
                MoodAnalyser moodAnalyser = (MoodAnalyser) reflectionObject;
                MoodAnalyser realMoodObject = new MoodAnalyser("I am in Sad Mood");
                boolean result = realMoodObject.equals(moodAnalyser);
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
        }

    @Test
    public void givenMoodAnalysers_whenImProper_shouldThrowClassNotFoundException() throws NoSuchMethodException, ClassNotFoundException {
        try {
            Constructor constructor = Class.forName("com.bridglabz.MoodAnalyser")
                    .getConstructor(String.class);
            Object reflectionObject = constructor.newInstance("I am in Sad Mood");
            MoodAnalyser moodAnalysers = (MoodAnalyser) reflectionObject;
            MoodAnalyser realMoodObject = new MoodAnalyser("I am in Sad Mood");
            boolean result = realMoodObject.equals(moodAnalysers);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            Assert.assertEquals("com.bridglabz.MoodAnalyser",e.getMessage());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}

