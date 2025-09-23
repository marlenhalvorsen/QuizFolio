package com.quizfolio.domain.model;

import java.util.UUID;

public abstract class Question {
    public enum Type { MULTIPLE_CHOICE, SHORT_ANSWER}

    private final UUID id;
    private final String prompt;
    private final Type type;

    protected Question(Type type, String prompt, UUID id){
        if (prompt == null || prompt.isBlank())
            throw new IllegalArgumentException("Prompt must not be blank");
        this.type = type;
        this.prompt = prompt;
        this.id = (id !=null) ? id : UUID.randomUUID();
    }

    protected Question(Type type, String prompt){
        this(type, prompt, null);
    }

    public UUID getId(){return id;}
    public String getPrompt() {return prompt;}
    public Type getType() {return type; }

}
