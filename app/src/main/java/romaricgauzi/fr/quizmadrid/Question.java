package romaricgauzi.fr.quizmadrid;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Question extends AppCompatActivity {

    public static String GROUP_ID = "C_00001";
    public static String QUESTION_ID = "C_00002";

    private int groupID;
    private int questionID;

    private TextView desc;
    private TextView questionView;
    private ImageView imageViewDesc;
    private TextView[] replyView = new TextView[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        if(intent != null){
            Bundle bundle = intent.getExtras();
            if(bundle != null){
                if(bundle.containsKey(GROUP_ID))this.groupID = bundle.getInt(GROUP_ID);
                if(bundle.containsKey(QUESTION_ID))this.questionID = bundle.getInt(QUESTION_ID);
            }else{
                closeActivity();
                return;
            }
        }else{
            closeActivity();
            return;
        }

        TextView questionNumberInd = findViewById(R.id.question_number);
        questionNumberInd.setText(String.valueOf(questionID+1));
        Groups.find(groupID).changeGroupBackground(questionNumberInd);

        final QuestionInfo questionInfo = Home.QUESTIONS[groupID][questionID];
        final String description = questionInfo.getDesc();
        final String imageDesc = questionInfo.getQuestionOptions().getImageDesc();
        final String questionTxt = questionInfo.getQuestion();
        final String[] answersTxt = questionInfo.getAnsweres();
        final int answered = questionInfo.getAnswered();


        desc = findViewById(R.id.desc);
        questionView = findViewById(R.id.question);
        imageViewDesc = findViewById(R.id.imageDesc);
        replyView[0] = findViewById(R.id.answer_1);
        replyView[1] = findViewById(R.id.answer_2);
        replyView[2] = findViewById(R.id.answer_3);
        replyView[3] = findViewById(R.id.answer_4);

        questionView.setText(questionTxt);
        if(description != null){
            this.desc.setVisibility(View.VISIBLE);
            this.desc.setText(description);
        }
        if(imageDesc != null){
            int id = getResources().getIdentifier(imageDesc, "drawable", getPackageName());
            if(id != 0)imageViewDesc.setImageResource(id);
        }


        for (int i = 0; i < 4; i++) {
            final int reponseNumber = i;
            if(answersTxt[i] != null) replyView[i].setText(answersTxt[i]);
            replyView[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    questionInfo.setAnswered(reponseNumber);
                    closeActivity();
                }
            });
            if(answered == i){
                replyView[i].setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.answer_button_validate) );
                replyView[i].setTextColor(getResources().getColor(R.color.white));
            }
        }
    }

    private void closeActivity(){
        finish();
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_menu_question, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.carte){
            Intent intent = new Intent(this, MapActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

}
