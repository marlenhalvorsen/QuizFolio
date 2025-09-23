package com.quizfolio.domain.model;

import java.util.UUID;

public final class ShortAnswerQuestion extends Question {

    private final String expectedAnswer;

    public ShortAnswerQuestion(UUID id, String prompt, String expectedAnswer){
        super(Type.SHORT_ANSWER, prompt, id);

        if(expectedAnswer == null || expectedAnswer.isBlank()) {
            throw new IllegalArgumentException("expectedAnswer must not be blank");
        }
        this.expectedAnswer = expectedAnswer;
    }

    public ShortAnswerQuestion(String prompt, String expectedAnswer){
        this(null, prompt, expectedAnswer);
    }

    public String getExpectedAnswer(){ return expectedAnswer;}

    //case-insensitive helper to check answer.
    public boolean isCorrect(String userAnswer){
        if(userAnswer == null) return false;
        return expectedAnswer.trim().equalsIgnoreCase(userAnswer.trim());
    }

    @Override
    public String toString(){
        return "ShortAnswerQuestion{" +
                "id=" + getId() +
                ", prompt='" + getPrompt() + '\'' +
                ", expectedAnswer='" + expectedAnswer + '\'' +
                '}';
    }
}


