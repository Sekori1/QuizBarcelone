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

    public final static String QUESTION_GROUP_ID = "QUESTION_GROUP_ID";

    private static QuestionGroup[] questions = new QuestionGroup[4];

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
        questions[0] = new QuestionGroup(getString(R.string.itineraryYellow), 0,
                new QuestionProfil(getString(R.string.yellow_question_1), getString(R.string.yellow_question_1_reply1), getString(R.string.yellow_question_1_reply2), getString(R.string.yellow_question_1_reply3), getString(R.string.yellow_question_1_reply4), 2),
                new QuestionProfil(getString(R.string.yellow_question_2), getString(R.string.yellow_question_2_reply1), getString(R.string.yellow_question_2_reply2), getString(R.string.yellow_question_2_reply3), getString(R.string.yellow_question_2_reply4), 2),
                new QuestionProfil(getString(R.string.yellow_question_3), getString(R.string.yellow_question_3_reply1), getString(R.string.yellow_question_3_reply2), getString(R.string.yellow_question_3_reply3), getString(R.string.yellow_question_3_reply4), 2),
                new QuestionProfil(getString(R.string.yellow_question_4), getString(R.string.yellow_question_4_reply1), getString(R.string.yellow_question_4_reply2), getString(R.string.yellow_question_4_reply3), getString(R.string.yellow_question_4_reply4), 2),
                new QuestionProfil(getString(R.string.yellow_question_1), getString(R.string.yellow_question_1_reply1), getString(R.string.yellow_question_1_reply2), getString(R.string.yellow_question_1_reply3), getString(R.string.yellow_question_1_reply4), 2),
                new QuestionProfil(getString(R.string.yellow_question_2), getString(R.string.yellow_question_2_reply1), getString(R.string.yellow_question_2_reply2), getString(R.string.yellow_question_2_reply3), getString(R.string.yellow_question_2_reply4), 2),
                new QuestionProfil(getString(R.string.yellow_question_3), getString(R.string.yellow_question_3_reply1), getString(R.string.yellow_question_3_reply2), getString(R.string.yellow_question_3_reply3), getString(R.string.yellow_question_3_reply4), 2),
                new QuestionProfil(getString(R.string.yellow_question_1), getString(R.string.yellow_question_1_reply1), getString(R.string.yellow_question_1_reply2), getString(R.string.yellow_question_1_reply3), getString(R.string.yellow_question_1_reply4), 2),
                new QuestionProfil(getString(R.string.yellow_question_2), getString(R.string.yellow_question_2_reply1), getString(R.string.yellow_question_2_reply2), getString(R.string.yellow_question_2_reply3), getString(R.string.yellow_question_2_reply4), 2),
                new QuestionProfil(getString(R.string.yellow_question_3), getString(R.string.yellow_question_3_reply1), getString(R.string.yellow_question_3_reply2), getString(R.string.yellow_question_3_reply3), getString(R.string.yellow_question_3_reply4), 2),
                new QuestionProfil(getString(R.string.yellow_question_4), getString(R.string.yellow_question_4_reply1), getString(R.string.yellow_question_4_reply2), getString(R.string.yellow_question_4_reply3), getString(R.string.yellow_question_4_reply4), 2),
                new QuestionProfil(getString(R.string.yellow_question_1), getString(R.string.yellow_question_1_reply1), getString(R.string.yellow_question_1_reply2), getString(R.string.yellow_question_1_reply3), getString(R.string.yellow_question_1_reply4), 2),
                new QuestionProfil(getString(R.string.yellow_question_2), getString(R.string.yellow_question_2_reply1), getString(R.string.yellow_question_2_reply2), getString(R.string.yellow_question_2_reply3), getString(R.string.yellow_question_2_reply4), 2),
                new QuestionProfil(getString(R.string.yellow_question_3), getString(R.string.yellow_question_3_reply1), getString(R.string.yellow_question_3_reply2), getString(R.string.yellow_question_3_reply3), getString(R.string.yellow_question_3_reply4), 2),
                new QuestionProfil(getString(R.string.yellow_question_1), getString(R.string.yellow_question_1_reply1), getString(R.string.yellow_question_1_reply2), getString(R.string.yellow_question_1_reply3), getString(R.string.yellow_question_1_reply4), 2),
                new QuestionProfil(getString(R.string.yellow_question_2), getString(R.string.yellow_question_2_reply1), getString(R.string.yellow_question_2_reply2), getString(R.string.yellow_question_2_reply3), getString(R.string.yellow_question_2_reply4), 2),
                new QuestionProfil(getString(R.string.yellow_question_3), getString(R.string.yellow_question_3_reply1), getString(R.string.yellow_question_3_reply2), getString(R.string.yellow_question_3_reply3), getString(R.string.yellow_question_3_reply4), 2),
                new QuestionProfil(getString(R.string.yellow_question_4), getString(R.string.yellow_question_4_reply1), getString(R.string.yellow_question_4_reply2), getString(R.string.yellow_question_4_reply3), getString(R.string.yellow_question_4_reply4), 2),
                new QuestionProfil(getString(R.string.yellow_question_1), getString(R.string.yellow_question_1_reply1), getString(R.string.yellow_question_1_reply2), getString(R.string.yellow_question_1_reply3), getString(R.string.yellow_question_1_reply4), 2),
                new QuestionProfil(getString(R.string.yellow_question_2), getString(R.string.yellow_question_2_reply1), getString(R.string.yellow_question_2_reply2), getString(R.string.yellow_question_2_reply3), getString(R.string.yellow_question_2_reply4), 2),
                new QuestionProfil(getString(R.string.yellow_question_3), getString(R.string.yellow_question_3_reply1), getString(R.string.yellow_question_3_reply2), getString(R.string.yellow_question_3_reply3), getString(R.string.yellow_question_3_reply4), 2)
        );
        questions[1] = new QuestionGroup(getString(R.string.itineraryYellow), 1,
                new QuestionProfil(getString(R.string.yellow_question_1), getString(R.string.yellow_question_1_reply1), getString(R.string.yellow_question_1_reply2), getString(R.string.yellow_question_1_reply3), getString(R.string.yellow_question_1_reply4), 2),
                new QuestionProfil(getString(R.string.yellow_question_2), getString(R.string.yellow_question_2_reply1), getString(R.string.yellow_question_2_reply2), getString(R.string.yellow_question_2_reply3), getString(R.string.yellow_question_2_reply4), 2),
                new QuestionProfil(getString(R.string.yellow_question_3), getString(R.string.yellow_question_3_reply1), getString(R.string.yellow_question_3_reply2), getString(R.string.yellow_question_3_reply3), getString(R.string.yellow_question_3_reply4), 2),
                new QuestionProfil(getString(R.string.yellow_question_4), getString(R.string.yellow_question_4_reply1), getString(R.string.yellow_question_4_reply2), getString(R.string.yellow_question_4_reply3), getString(R.string.yellow_question_4_reply4), 2)
        );
        questions[2] = new QuestionGroup(getString(R.string.itineraryYellow), 2,
                new QuestionProfil(getString(R.string.yellow_question_1), getString(R.string.yellow_question_1_reply1), getString(R.string.yellow_question_1_reply2), getString(R.string.yellow_question_1_reply3), getString(R.string.yellow_question_1_reply4), 2),
                new QuestionProfil(getString(R.string.yellow_question_2), getString(R.string.yellow_question_2_reply1), getString(R.string.yellow_question_2_reply2), getString(R.string.yellow_question_2_reply3), getString(R.string.yellow_question_2_reply4), 2),
                new QuestionProfil(getString(R.string.yellow_question_3), getString(R.string.yellow_question_3_reply1), getString(R.string.yellow_question_3_reply2), getString(R.string.yellow_question_3_reply3), getString(R.string.yellow_question_3_reply4), 2),
                new QuestionProfil(getString(R.string.yellow_question_4), getString(R.string.yellow_question_4_reply1), getString(R.string.yellow_question_4_reply2), getString(R.string.yellow_question_4_reply3), getString(R.string.yellow_question_4_reply4), 2)
        );
        questions[3] = new QuestionGroup(getString(R.string.itineraryYellow), 3,
                new QuestionProfil(getString(R.string.yellow_question_1), getString(R.string.yellow_question_1_reply1), getString(R.string.yellow_question_1_reply2), getString(R.string.yellow_question_1_reply3), getString(R.string.yellow_question_1_reply4), 2),
                new QuestionProfil(getString(R.string.yellow_question_2), getString(R.string.yellow_question_2_reply1), getString(R.string.yellow_question_2_reply2), getString(R.string.yellow_question_2_reply3), getString(R.string.yellow_question_2_reply4), 2),
                new QuestionProfil(getString(R.string.yellow_question_3), getString(R.string.yellow_question_3_reply1), getString(R.string.yellow_question_3_reply2), getString(R.string.yellow_question_3_reply3), getString(R.string.yellow_question_3_reply4), 2),
                new QuestionProfil(getString(R.string.yellow_question_4), getString(R.string.yellow_question_4_reply1), getString(R.string.yellow_question_4_reply2), getString(R.string.yellow_question_4_reply3), getString(R.string.yellow_question_4_reply4), 2)
        );

    }

    public void selectRedItineraire(View view) {
        selectItineraire(0);
    }

    public void selectBlueItineraire(View view) {
        selectItineraire(1);
    }

    public void selectYellowItineraire(View view) {
        selectItineraire(2);
    }

    public void selectGreenItineraire(View view) {
        selectItineraire(3);
    }

    public void selectItineraire(int id){
        Intent intent = new Intent(this, QuestionList.class);
        intent.putExtra(QUESTION_GROUP_ID, id);
        startActivity(intent);
    }

    public static void selectExtraGroup(Intent intent, int id){
        intent.putExtra(QUESTION_GROUP_ID, id);
    }

    public static QuestionGroup getQuestionGroup(Intent intent){
        if(intent != null){
            Bundle bundle = intent.getExtras();
            if(bundle != null){
                if(bundle.containsKey(QUESTION_GROUP_ID)){
                    return getQuestionGroup(bundle.getInt(QUESTION_GROUP_ID));
                }
            }
        }
        return null;
    }

    public static QuestionGroup getQuestionGroup(int id){
        return questions[id];
    }
}
