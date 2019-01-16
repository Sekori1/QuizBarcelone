package romaricgauzi.fr.quizmadrid;

public class QuestionProfil {

    private String question;

    private String reply1;
    private String reply2;
    private String reply3;
    private String reply4;

    private int valideReply;

    public QuestionProfil(String question, String reply1, String reply2, String reply3, String reply4, int valideReply) {
        this.question = question;
        this.reply1 = reply1;
        this.reply2 = reply2;
        this.reply3 = reply3;
        this.reply4 = reply4;
        this.valideReply = valideReply;
    }
}
