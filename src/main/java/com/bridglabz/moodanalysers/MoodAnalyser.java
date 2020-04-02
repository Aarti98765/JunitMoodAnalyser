package com.bridglabz.moodanalysers;

public class MoodAnalyser {
    public String getMood(String message) {
        if (message.contains("sad"))
            return "SAD";
        return "HAPPY";
    }
}
