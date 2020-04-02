package com.bridglabz.moodanalysers;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {
    @Test
    public void givenSadMessage_whenGetMood_shouldReturnSadMood() {
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        String mood = moodAnalyser.getMood("I am in sad mood");
        Assert.assertEquals("SAD", mood);
    }
}
