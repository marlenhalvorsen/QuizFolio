package com.quizfolio.domain.model;

import java.util.List;
import java.util.UUID;

public final class McQuestion extends Question {

    private final List<String> choices;
    private final int correctChoiceIndex;

    //Final class means cannot be inherited
    public McQuestion(UUID id, String prompt, List<String> choices, int correctChoiceIndex){
        super(Type.MULTIPLE_CHOICE, prompt, id);//Initialize superClass properties as there are none auto-generated properties

        if(choices == null || choices.size() < 2){
            throw new IllegalArgumentException("choices must have at least 2 items");
        }

        if(correctChoiceIndex < 0 || correctChoiceIndex >= choices.size()) {
            throw new IllegalArgumentException("correctChoiceIndex out of range");
        }

        this.choices = List.copyOf(choices); //.copyOf makes list immutable
        this.correctChoiceIndex = correctChoiceIndex;
    }

    public McQuestion(String prompt, List<String> choices, int correctChoiceIndex){
        this(null, prompt, choices, correctChoiceIndex);
    }

    public List<String> getChoices(){ return choices; }
    public int getCorrectChoiceIndex(){return correctChoiceIndex;}

    public String getCorrectChoice(){
        return choices.get(correctChoiceIndex);
    }

    @Override
    public String toString(){
        return "McqQuestion{" +
                "id=" + getId() +
                ", prompt='" + getPrompt() + '\'' +
                ", correctChoiceIndex=" + correctChoiceIndex +
                '}';
    }
}
