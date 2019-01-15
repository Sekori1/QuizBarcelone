package romaricgauzi.fr.quizmadrid;

public class QuestionProfil {

    private String reply1;
    private String reply2;
    private String reply3;
    private String reply4;

    private byte valideReply;

    public QuestionProfil(String reply1, String reply2, String reply3, String reply4, byte valideReply) {
        this.reply1 = reply1;
        this.reply2 = reply2;
        this.reply3 = reply3;
        this.reply4 = reply4;
        this.valideReply = valideReply;
    }
}
