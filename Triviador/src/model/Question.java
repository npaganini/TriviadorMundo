package model;

import java.io.Serializable;

public abstract class Question implements Serializable {
    private String question;

    public Question(String question){
        this.question=question;
    }

    public String getQuestion(){
        return question;
    }

    public abstract void print();
}
