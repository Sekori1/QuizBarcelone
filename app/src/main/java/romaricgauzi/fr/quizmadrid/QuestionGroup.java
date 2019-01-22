package romaricgauzi.fr.quizmadrid;

public class QuestionGroup {

    private String groupName;
    private int[] registedAnswer;
    private QuestionProfil[] questionProfils;

    public QuestionGroup(String groupName, QuestionProfil... questionProfils) {
        this.groupName = groupName;
        this.questionProfils = questionProfils;
        this.registedAnswer = new int[questionProfils.length];
    }

    public int getAnswereOf(int index){
        if(index >= questionProfils.length)return -1;
        return registedAnswer[index];
    }

    public QuestionProfil[] getQuestionProfils() {
        return questionProfils;
    }
}
