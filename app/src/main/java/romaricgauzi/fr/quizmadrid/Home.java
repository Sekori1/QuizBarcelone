package romaricgauzi.fr.quizmadrid;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.SystemClock;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.format.Time;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Chronometer;
import android.widget.ProgressBar;

public class Home extends AppCompatActivity {

    private final static int MAX_TIME = 7200000;
    private final static int BACK_ALERT = 10;
    private final static int VALIDE_ALERT = 11;
    private final static int NO_ANSWER_ALL = 12;
    private final static int NO_TIME = 13;


    private BottomNavigationView bottomNavigationView;
    private ProgressBar progressBar;
    private ProgressBar chronoBar;
    private Chronometer simpleChronometer;

    public final static String QUESTION_GROUP_ID = "QUESTION_GROUP_ID";

    public static String PACKAGE_NAME;

    public final static QuestionInfo[][] QUESTIONS = new QuestionInfo[4][];
    public static String TEAM_NAME;
    public static String[] PLAYERS;
    public static String FINAL_TIME = "0h00";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        PACKAGE_NAME = getPackageName();

        this.bottomNavigationView = findViewById(R.id.activity_main_bottom_navigation);
        this.progressBar = findViewById(R.id.progress_bar);
        this.chronoBar = findViewById(R.id.chronoBar);

        simpleChronometer = findViewById(R.id.simpleChronometer); // initiate a chronometer

        simpleChronometer.start(); // start a chronometer

        simpleChronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                Time time = new Time();
                time.setToNow();
                long el = SystemClock.elapsedRealtime();
                long base = chronometer.getBase();
                double dif = el - base;
                double m = (dif / MAX_TIME) * 1000;
                int i =  Double.valueOf(m).intValue();
                chronoBar.setProgress(i);
                chronoBar.setMax(1000);

            }
        });

        /*
            Chargement des questions depuis les ressources
         */
        for (int i = 0; i < 4; i++) {
            QuestionInfo[] questionInfos = new QuestionInfo[8];
            for (int j = 0; j < 8; j++) {
                questionInfos[j] = getQuestionRes(this, i, j);
                Log.d("QUESTIONS" ,  "GROUP ID:" + i + " QUESTION ID:" + j + " " +  questionInfos[j].getQuestion());
                String[] letter = {"A","B","C","D"};
                for (int k = 0; k < 4; k++) {
                    Log.d("QUESTIONS" ,  letter[k] + ") " +  questionInfos[j].getAnsweres()[k]);
                }
            }
            QUESTIONS[i] = questionInfos;
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        final ViewPager viewPager = findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), 4);
        viewPager.setAdapter(adapter);

        BottomNavListener bottomNavListener = new BottomNavListener(bottomNavigationView, viewPager);

        viewPager.addOnPageChangeListener(bottomNavListener);
        bottomNavigationView.setOnNavigationItemSelectedListener(bottomNavListener);

        updateProgressBar();

    }

    @Override
    protected void onStart() {
        super.onStart();

        updateProgressBar();
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            showDialog(BACK_ALERT);
            return false;
        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case BACK_ALERT:
                // Create out AlterDialog
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Voulez-vous vraiment quitter le Quiz ?");
                builder.setCancelable(true);
                builder.setPositiveButton("Quitter", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onBackPressed();
                    }
                });
                builder.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
                break;
            case VALIDE_ALERT:
                AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
                builder2.setMessage("Voulez-vous vraiment valider vos réponses?");
                builder2.setCancelable(true);
                builder2.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Home.this, FinishActivity.class);
                        FINAL_TIME = getPlayTime();
                        startActivity(intent);
                        finish();
                    }
                });
                builder2.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog dialog2 = builder2.create();
                dialog2.show();
                break;
            case NO_ANSWER_ALL:
                AlertDialog.Builder builder3 = new AlertDialog.Builder(this);
                builder3.setMessage("Vous ne pouvez pas valider vos réponses si vous n'avez pas répondu à toutes les questions!");
                builder3.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog dialog3 = builder3.create();
                dialog3.show();
                break;
            case NO_TIME:
                AlertDialog.Builder builder4 = new AlertDialog.Builder(this);
                builder4.setMessage("Vous ne pourrez valider vos réponses qu'au bout d'une heure.");
                builder4.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog dialog4 = builder4.create();
                dialog4.show();
                break;
        }
        return super.onCreateDialog(id);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.valide) {
            if(allQuestionsAnswered()){
                if(getChronometerTime() > MAX_TIME/2){
                    showDialog(VALIDE_ALERT);
                }else{
                    showDialog(NO_TIME);
                }
            }else{
                if(getChronometerTime() > MAX_TIME){
                    showDialog(VALIDE_ALERT);
                }else{
                    showDialog(NO_ANSWER_ALL);
                }
            }
        } else if(id == R.id.carte){
            Intent intent = new Intent(this, MapActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    public static QuestionInfo getQuestionRes(Context context, int groupID, int questionID){
        /* FORMAT QUESTION G<NUMBER>Q<Number><Q|D|R<0|1|2|3>> */
        QuestionInfo questionInfo = new QuestionInfo(groupID,questionID);
        questionInfo.setQuestion(findStringFromResources(context,"G" + groupID + "Q" + questionID + "Q"));
        String[] answers = new String[4];
        String[] images = new String[4];
        for (int i = 0; i < answers.length; i++){
            answers[i] = findStringFromResources(context,"G" + groupID + "Q" + questionID + "A" + i);
        }
        questionInfo.setAnsweres(answers);
        questionInfo.setDesc( findStringFromResources(context,"G" + groupID + "Q" + questionID + "DESC"));
        return questionInfo;
    }

    public static String findStringFromResources(Context context, String name) {
        Resources res = context.getResources();
        try {
            return res.getString(res.getIdentifier(name, "string", context.getPackageName()));
        } catch (Exception e){
            return null;
        }
    }

    public void updateProgressBar(){
        int max = 0;
        int answered = 0;
        for(QuestionInfo[] questions : QUESTIONS){
            for(QuestionInfo questionInfo : questions){
                max++;
                if(questionInfo.getAnswered() >= 0)answered++;
            }
        }
        progressBar.setMax(max);
        progressBar.setProgress(answered);
    }

    public boolean allQuestionsAnswered(){
        int max = 0;
        int answered = 0;
        for(QuestionInfo[] questions : QUESTIONS){
            for(QuestionInfo questionInfo : questions){
                max++;
                if(questionInfo.getAnswered() >= 0)answered++;
            }
        }
        return max == answered;//TODO
    }

    public static String getScore(){
        return getIntegerScore() + "/" + getIntegerMaxScore();
    }

    public static int getIntegerScore(){
        int valide = 0;
        for(QuestionInfo[] questions : QUESTIONS){
            for(QuestionInfo questionInfo : questions){
                if(questionInfo.getAnswered() >= 0){
                    if(questionInfo.getAnswered() == questionInfo.getQuestionOptions().getValideAnswer()){
                        valide++;
                    }
                }
            }
        }
        return valide;
    }

    public static int getIntegerMaxScore(){
        int max = 0;
        for(QuestionInfo[] questions : QUESTIONS){
            max += questions.length;
        }
        return max;
    }

    public double getChronometerTime(){
        long el = SystemClock.elapsedRealtime();
        long base = simpleChronometer.getBase();
        double dif = el - base;
        return dif;
    }

    public String getPlayTime(){
        double d = getChronometerTime();
        double stotal = d/1000;
        int hours = Double.valueOf(stotal / 3600).intValue();
        int mins = Double.valueOf(((stotal / 60) % 60)).intValue();
        return hours + "h" + mins;
    }
}
