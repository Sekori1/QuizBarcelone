package romaricgauzi.fr.quizmadrid;

public class QuestionGroup {

    private String groupName;
    private int id;
    private int[] registedAnswer;
    private QuestionProfil[] questionProfils;

    public QuestionGroup(String groupName, int id, QuestionProfil... questionProfils) {
        this.groupName = groupName;
        this.id = id;
        this.questionProfils = questionProfils;
        this.registedAnswer = new int[questionProfils.length];
    }

    public int getAnswereOf(int index){
        if(index >= questionProfils.length)return -1;
        return registedAnswer[index];
    }

    public void setAnswereOf(int index, int answer){
        registedAnswer[index] = answer;
    }

    public QuestionProfil[] getQuestionProfils() {
        return questionProfils;
    }

    public int getId() {
        return id;
    }

    public int getQuestionAmount(){
        return questionProfils.length;
    }
}
