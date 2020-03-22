package romaricgauzi.fr.quizmadrid;

public enum QuestionOptions {

    Q00(0,0,true,0, "g0q0"),
    Q01(0,1,true,2,"g0q1","form1","form2","form3","form4"),
    Q02(0,2,false,2,"g0q2"),
    Q03(0,3,false,1,"g0q3"),
    Q04(0,4,false,0,"g0q3"),
    Q05(0,5,false,2,"g0q5"),
    Q06(0,6,false,2,"g0q6"),
    Q07(0,7,false,1,"g0q6"),
    Q10(1,0,true,0,"g1q0"),
    Q11(1,1,false,2,"g1q0"),
    Q12(1,2,true,2,"g1q2"),
    Q13(1,3,false,1,"g1q2"),
    Q14(1,4,false,0,"g1q4"),
    Q15(1,5,false,2,"g1q5"),
    Q16(1,6,true,2,"g1q6"),
    Q17(1,7,false,1,"g1q7"),
    Q20(2,0,false,0,"g2q0"),
    Q21(2,1,false,2,"g2q1"),
    Q22(2,2,false,2,"g2q2"),
    Q23(2,3,false,1,"g2q3"),
    Q24(2,4,true,0,"g2q4"),
    Q25(2,5,false,2,"g2q4"),
    Q26(2,6,false,2,"g2q6"),
    Q27(2,7,false,1,"g2q6"),
    Q30(3,0,false,0,"g3q0"),
    Q31(3,1,false,2,"g3q0"),
    Q32(3,2,false,2,"g3q2"),
    Q33(3,3,false,1,"g3q3"),
    Q34(3,4,false,0,"g3q4"),
    Q35(3,5,false,2,"g3q4"),
    Q36(3,6,false,2,"g3q6"),
    Q37(3,7,false,1,"g3q7");


    private int groupID;
    private int questionID;
    private boolean gridPresentation;
    private int valideAnswer;
    private String imageDesc;
    private String[] imagesAnswers;

    QuestionOptions(int groupID, int questionID, boolean gridPresentation, int valideAnswer, String imageDesc, String... imagesAnswers) {
        this.groupID = groupID;
        this.questionID = questionID;
        this.gridPresentation = gridPresentation;
        this.valideAnswer = valideAnswer;
        this.imageDesc = imageDesc;
        this.imagesAnswers = imagesAnswers;
    }


    public static QuestionOptions find(int groupID, int questionID){
        return valueOf("Q" + groupID + questionID);
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public boolean isGridPresentation() {
        return gridPresentation;
    }

    public void setGridPresentation(boolean gridPresentation) {
        this.gridPresentation = gridPresentation;
    }

    public int getValideAnswer() {
        return valideAnswer;
    }

    public void setValideAnswer(int valideAnswer) {
        this.valideAnswer = valideAnswer;
    }

    public String getImageDesc() {
        return imageDesc;
    }

    public void setImageDesc(String imageDesc) {
        this.imageDesc = imageDesc;
    }

    public String[] getImagesAnswers() {
        return imagesAnswers;
    }

    public void setImagesAnswers(String[] imagesAnswers) {
        this.imagesAnswers = imagesAnswers;
    }
}
