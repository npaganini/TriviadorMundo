package triviadormundo;

public abstract class Question {
    private String question;

    public Question(String question){
        this.question=question;
    }

    public String getQuestion(){
        return question;
    }

    public abstract void print();
}
