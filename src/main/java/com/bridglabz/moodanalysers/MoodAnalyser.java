package com.bridglabz.moodanalysers;

import com.bridglabz.moodanalysers.exceptions.MoodAnalyserException;

import java.util.Objects;

public class MoodAnalyser {
    String message;

    public MoodAnalyser(String message) {
        this.message = message;
    }

    public MoodAnalyser () {
    }

    public String getMood(String message) {
        if (message.contains("sad"))
            return "SAD";
        return "HAPPY";
    }

    public String analyseMood() throws MoodAnalyserException {
        try {
            if(message.length()== 0)
                throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.EMTY,"Mood should not be empty");
            else if(message.contains("sad"))
                return "SAD";
            return "HAPPY";
        } catch (NullPointerException nullPointerException) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.NULL, "Invalid Message");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoodAnalyser that = (MoodAnalyser) o;
        return Objects.equals(message, that.message);
    }

}