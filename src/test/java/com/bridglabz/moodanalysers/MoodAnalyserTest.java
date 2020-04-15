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
        } catch (MoodAnalyserException moodAnalysisException) {
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
    public void givenMoodAnalyser_whenProper_shouldReturnObject() throws MoodAnalyserException, IllegalAccessException, InstantiationException, InvocationTargetException {
        MoodAnalyser moodAnalyser = new MoodAnalyser("Hello");
        Constructor constructor = MoodAnalyserFactory.getConstructor("MoodAnalyser",String.class);
        MoodAnalyser moodAnalyserObject = MoodAnalyserFactory.getMoodAnalyserObject(constructor,"Hello");
        boolean result = moodAnalyser.equals(moodAnalyserObject);
        Assert.assertTrue("true",result);
    }

    @Test
    public void givenMoodAnalyser_whenImProper_shouldThrowClassNotFoundException() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        MoodAnalyser moodAnalyserObject = null;
        try{
            MoodAnalyserFactory.getConstructor("MoodAnalysers",String.class);
        } catch (MoodAnalyserException moodAnalysisException){
            Assert.assertEquals("Invalid class name", moodAnalysisException.getMessage());
        }
    }

    @Test
    public void givenMoodAnalyser_whenImProperConstructorParameters_shouldThrowNoSuchMethodException() throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        try {
                MoodAnalyserFactory.getConstructor("MoodAnalyser",String.class, Integer.class);
        } catch (MoodAnalyserException e) {
            try {
                throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.NOSUCHMETHOD,
                        "Invalid constructor");
            } catch (MoodAnalyserException moodAnalysisException) {
                Assert.assertEquals("Invalid constructor", moodAnalysisException.getMessage());
            }
        }
    }

    @Test
    public void givenHappyMessage_WhenProper_ShouldReturnHappy() {
        try {
            Constructor constructor = MoodAnalyserFactory.getConstructor("MoodAnalyser",String.class);
            Object moodAnalyserObject = MoodAnalyserFactory.getMoodAnalyserObject(constructor,"I am in Happy mood");
            Object mood = MoodAnalyserFactory.invokeMethod(moodAnalyserObject, "analyseMood");
            Assert.assertEquals("HAPPY",mood);
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenHappyMessage_WhenImproper_ShouldReturnHappy() throws MoodAnalyserException {
        try {
            Constructor constructor = MoodAnalyserFactory.getConstructor("MoodAnalyzer",String.class);
            Object moodAnalyserObject = MoodAnalyserFactory.getMoodAnalyserObject(constructor,"I am in Happy mood");
            Object mood = MoodAnalyserFactory.invokeMethod(moodAnalyserObject, "AnalyseMood");

        } catch (MoodAnalyserException e) {
            Assert.assertEquals(MoodAnalyserException.ExceptionType.NOSUCHMETHOD,e.type);

        }
    }
}

