package romaricgauzi.fr.quizmadrid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Question extends AppCompatActivity {

    public static String QUESTION_MESSAGE = "QUESTION_MESSAGE";
    public static String REPLY1_MESSAGE = "REPLY1_MESSAGE";
    public static String REPLY2_MESSAGE = "REPLY2_MESSAGE";
    public static String REPLY3_MESSAGE = "REPLY3_MESSAGE";
    public static String REPLY4_MESSAGE = "REPLY4_MESSAGE";

    private String question;
    private String reply1;
    private String reply2;
    private String reply3;
    private String reply4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        Intent intent = getIntent();

        if(intent != null){
            Bundle bundle = intent.getExtras();
            if(bundle != null){
                if(bundle.containsKey(QUESTION_MESSAGE))this.question = bundle.getString(QUESTION_MESSAGE);
                if(bundle.containsKey(REPLY1_MESSAGE))this.reply1 = bundle.getString(REPLY1_MESSAGE);
                if(bundle.containsKey(REPLY2_MESSAGE))this.reply2 = bundle.getString(REPLY2_MESSAGE);
                if(bundle.containsKey(REPLY3_MESSAGE))this.reply3 = bundle.getString(REPLY3_MESSAGE);
                if(bundle.containsKey(REPLY4_MESSAGE))this.reply4 = bundle.getString(REPLY4_MESSAGE);
            }else{
                closeActivity();
            }
        }else{
            closeActivity();
        }
    }

    private void closeActivity(){
        //TODO open an other activitu
        finish();
    }
}
