package model;

import java.io.Serializable;

public class AproximationQuestion extends Question implements Serializable {
    private Integer answer;

    public AproximationQuestion(String question, Integer answer){
        super(question);
        this.answer=answer;
    }

    public Integer getAnswer(){
        return answer;
    }

    public void print() {
        System.out.println(answer);

    }
}
