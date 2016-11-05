package model;

public class MultipleChoiceQuestion extends Question {
    private String answer[];
    private Integer correctAnswerIndex; /** aca guardo el numero de la respuesta correcta en array answer */
    private final static Integer ANSWERS = 4; /*esta es la cantidad total de respuestas que guardamos, CONSTANTE */

    public MultipleChoiceQuestion(String question, String[] answer, int correctAnswerIndex){
        super(question);
        this.answer=answer;
        this.correctAnswerIndex=correctAnswerIndex;
    }

    public String[] getAnswers(){
        return answer;
    }

    public Integer getCorrectAnswerIndex(){
        return correctAnswerIndex;
    }

    public String getAnswer(int index){
        return answer[index];
    }

    public void print(){
        for(int i=0; i<ANSWERS; i++){
            System.out.println(i+1 +") " + answer[i]);
        }
    }
}
