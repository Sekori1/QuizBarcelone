package romaricgauzi.fr.quizmadrid;

public class QuestionRes {

    private String question;
    private String[] answeres;

    public QuestionRes() {
    }

    public QuestionRes(String question, String... answeres) {
        this.question = question;
        this.answeres = answeres;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getAnsweres() {
        return answeres;
    }

    public void setAnsweres(String[] answeres) {
        this.answeres = answeres;
    }
}
