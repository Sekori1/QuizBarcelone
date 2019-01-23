package romaricgauzi.fr.quizmadrid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Question extends AppCompatActivity {

    public static String QUESTION_GROUP_ID_MESSAGE = "QUESTION_GROUP_ID_MESSAGE";
    public static String QUESTION_ID_MESSAGE = "QUESTION_ID_MESSAGE";
    public static String QUESTION_MESSAGE = "QUESTION_MESSAGE";
    public static String REPLY_MESSAGE = "REPLY_MESSAGE";


    private int question_id;
    private int question_group_id;

    private String question;
    private String[] reply = new String[4];

    private TextView questionView;
    private TextView[] replyView = new TextView[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        Intent intent = getIntent();

        if(intent != null){
            Bundle bundle = intent.getExtras();
            if(bundle != null){
                if(bundle.containsKey(QUESTION_MESSAGE))this.question = bundle.getString(QUESTION_MESSAGE);
                if(bundle.containsKey(REPLY_MESSAGE))this.reply = bundle.getStringArray(REPLY_MESSAGE);
                if(bundle.containsKey(QUESTION_GROUP_ID_MESSAGE))this.question_group_id = bundle.getInt(QUESTION_GROUP_ID_MESSAGE);
                if(bundle.containsKey(QUESTION_ID_MESSAGE))this.question_id = bundle.getInt(QUESTION_ID_MESSAGE);
            }else{
                closeActivity();
                return;
            }
        }else{
            closeActivity();
            return;
        }

        questionView = findViewById(R.id.question);
        replyView[0] = findViewById(R.id.reply1);
        replyView[1] = findViewById(R.id.reply2);
        replyView[2] = findViewById(R.id.reply3);
        replyView[3] = findViewById(R.id.reply4);

        questionView.setText(question);
        for (int i = 0; i < 4; i++) {
            final int reponseNumber = i+1;
            replyView[i].setText(reply[i]);
            replyView[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    HomelessnessList.getQuestionGroup(question_group_id).setAnswereOf(question_id, reponseNumber);
                    closeActivity();
                }
            });
        }
    }

    private void closeActivity(){
        //TODO open an other activitu
        Intent intent = new Intent(this, QuestionList.class);

        HomelessnessList.selectExtraGroup(intent, question_group_id);
        startActivity(intent);

        finish();
    }
}
