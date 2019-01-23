package romaricgauzi.fr.quizmadrid;

public class QuestionProfil {

    private String question;

    private String[] reply = new String[4];

    private int valideReply;

    public QuestionProfil(String question, String reply1, String reply2, String reply3, String reply4, int valideReply) {
        this.question = question;
        this.reply[0] = reply1;
        this.reply[1] = reply2;
        this.reply[2] = reply3;
        this.reply[3] = reply4;
        this.valideReply = valideReply;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getReply() {
        return reply;
    }

    public int getValideReply() {
        return valideReply;
    }
}
