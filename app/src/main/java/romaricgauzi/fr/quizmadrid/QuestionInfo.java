package romaricgauzi.fr.quizmadrid;

public class QuestionInfo {

    private int groupID;
    private int questionID;
    private QuestionOptions questionOptions;

    private String question;
    private String[] answeres;
    private String desc;

    private int answered = -1;

    public QuestionInfo(int groupID, int questionID) {
        this.groupID = groupID;
        this.questionID = questionID;
        this.questionOptions = QuestionOptions.find(groupID,questionID);
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

    public String[] getImages() {
        return questionOptions.getImagesAnswers();
    }

    public int getGroupID() {
        return groupID;
    }

    public int getQuestionID() {
        return questionID;
    }

    public QuestionOptions getQuestionOptions() {
        return questionOptions;
    }

    public int getAnswered() {
        return answered;
    }

    public void setAnswered(int answered) {
        this.answered = answered;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
