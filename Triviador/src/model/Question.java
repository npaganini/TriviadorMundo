package model;

import java.io.Serializable;

public abstract class Question implements Serializable {

	private static final long serialVersionUID = 1L;
	private String question;

    public Question(String question){
        this.question=question;
    }

    public String getQuestion(){
        return question;
    }

    public abstract void print();
}
