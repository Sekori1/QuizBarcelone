package romaricgauzi.fr.quizmadrid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;

public class HomelessnessList extends AppCompatActivity {

    private String teamName;
    private Chronometer chronometer;
    private TextView teamTitle;

    public final static String QUESTION_GROUP_TYPE = "QUESTION_GROUP_TYPE";

    public final static String YELLOW_HOMELESSNESS = "YELLOW_HOMELESSNESS";
    public final static String RED_HOMELESSNESS = "RED_HOMELESSNESS";
    public final static String BLUE_HOMELESSNESS = "BLUE_HOMELESSNESS";
    public final static String GREEN_HOMELESSNESS = "GREEN_HOMELESSNESS";

    private static QuestionGroup yellowQuestions;
    private static QuestionGroup redQuestions;
    private static QuestionGroup blueQuestions;
    private static QuestionGroup greenQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homelessness_list);

        this.teamTitle = findViewById(R.id.teamNameHeader);
        this.chronometer = findViewById(R.id.chrono);

        Intent intent = getIntent();
        if(intent != null && teamTitle != null){
            Bundle bundle = intent.getExtras();
            if(bundle != null && bundle.containsKey(MainActivity.TEAM_NAME_MESSAGE)){
                this.teamName = intent.getStringExtra(MainActivity.TEAM_NAME_MESSAGE);
                this.teamTitle.setText(teamName);
            }
        }

        if(chronometer != null){
            this.chronometer.setFormat(("Temps: %s"));
            this.chronometer.start();
            this.chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                @Override
                public void onChronometerTick(Chronometer chronometer) {

                }
            });
        }

        yellowQuestions = new QuestionGroup(getString(R.string.itineraryYellow),
                new QuestionProfil(getString(R.string.yellow_question_1), getString(R.string.yellow_question_1_reply1), getString(R.string.yellow_question_1_reply2), getString(R.string.yellow_question_1_reply3), getString(R.string.yellow_question_1_reply4), 2),
                new QuestionProfil(getString(R.string.yellow_question_2), getString(R.string.yellow_question_2_reply1), getString(R.string.yellow_question_2_reply2), getString(R.string.yellow_question_2_reply3), getString(R.string.yellow_question_2_reply4), 2),
                new QuestionProfil(getString(R.string.yellow_question_3), getString(R.string.yellow_question_3_reply1), getString(R.string.yellow_question_3_reply2), getString(R.string.yellow_question_3_reply3), getString(R.string.yellow_question_3_reply4), 2),
                new QuestionProfil(getString(R.string.yellow_question_4), getString(R.string.yellow_question_4_reply1), getString(R.string.yellow_question_4_reply2), getString(R.string.yellow_question_4_reply3), getString(R.string.yellow_question_4_reply4), 2)
        );

    }

    public void selectRedItineraire(View view) {
        selectItineraire(RED_HOMELESSNESS);
    }

    public void selectBlueItineraire(View view) {
        selectItineraire(BLUE_HOMELESSNESS);
    }

    public void selectYellowItineraire(View view) {
        selectItineraire(YELLOW_HOMELESSNESS);
    }

    public void selectGreenItineraire(View view) {
        selectItineraire(GREEN_HOMELESSNESS);
    }


    public void selectItineraire(String hln){
        Intent intent = new Intent(this, QuestionList.class);
        intent.putExtra(QUESTION_GROUP_TYPE, hln);
        startActivity(intent);
    }

    public static QuestionGroup getQuestionGroup(Intent intent){
        if(intent != null){
            Bundle bundle = intent.getExtras();
            if(bundle != null){
                if(bundle.containsKey(QUESTION_GROUP_TYPE)){
                    return getQuestionGroup(bundle.getString(QUESTION_GROUP_TYPE));
                }
            }
        }
        return null;
    }

    public static QuestionGroup getQuestionGroup(String key){
        switch (key){
            case YELLOW_HOMELESSNESS: return yellowQuestions;
            case RED_HOMELESSNESS: return redQuestions;
            case BLUE_HOMELESSNESS: return blueQuestions;
            case GREEN_HOMELESSNESS: return greenQuestions;
        }
        return null;
    }
}
