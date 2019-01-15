package romaricgauzi.fr.quizmadrid;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Chronometer;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class QuestionList extends AppCompatActivity {

    private String teamName;
    private Chronometer chronometer;
    private TextView teamTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_list);

        this.teamTitle = findViewById(R.id.teamNameHeader);
        this.chronometer = findViewById(R.id.chrono);



        Intent intent = getIntent();
        if(intent != null){
            this.teamName = intent.getStringExtra(MainActivity.TEAM_NAME_MESSAGE);
            this.teamTitle.setText(teamName);
        }

        this.chronometer.setBase(SystemClock.elapsedRealtime() + TimeUnit.MINUTES.toMillis(120));
        this.chronometer.setFormat(("Temps: %s"));
        this.chronometer.start();
        this.chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {

            }
        });

    }
}
