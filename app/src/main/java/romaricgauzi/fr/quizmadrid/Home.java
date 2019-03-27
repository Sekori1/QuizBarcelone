package romaricgauzi.fr.quizmadrid;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

public class Home extends AppCompatActivity {

    private final static int BACK_ALERT = 10;

    private BottomNavigationView bottomNavigationView;
    private ProgressBar progressBar;

    public final static String QUESTION_GROUP_ID = "QUESTION_GROUP_ID";

    public static String PACKAGE_NAME;

    private static QuestionGroup[] questions = new QuestionGroup[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        PACKAGE_NAME = getPackageName();

        this.bottomNavigationView = findViewById(R.id.activity_main_bottom_navigation);
        this.progressBar = findViewById(R.id.progress_bar);

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
        }
        return super.onCreateDialog(id);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_menu, menu);
        return true;
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

    public static QuestionRes getQuestionRes(Context context, int groupID, int questionID){
        /* FORMAT QUESTION
        *
        *   G<NUMBER>Q<Number><Q|D|R<0|1|2|3>>
         */
        QuestionRes questionRes = new QuestionRes();
        questionRes.setQuestion(findStringFromResources(context,"G" + groupID + "Q" + questionID + "Q"));
        String[] answers = new String[4];
        for (int i = 0; i < answers.length; i++) answers[i] = findStringFromResources(context,"G" + groupID + "Q" + questionID + "A" + i);
        questionRes.setAnsweres(answers);
        return questionRes;
    }

    public static String findStringFromResources(Context context, String name) {
        Resources res = context.getResources();
        return res.getString(res.getIdentifier(name, "string", context.getPackageName()));
    }


    public static QuestionGroup getQuestionGroup(int id){
        return questions[id];
    }

    public void updateProgressBar(){
        int max = 0;
        int answered = 0;
        for(QuestionGroup questionGroup : questions){
            max += questionGroup.getQuestionAmount();
            for(int i = 0; i < max; i++){
                if(questionGroup.getAnswereOf(i) > 0)answered++;
            }
        }
        progressBar.setMax(max);
        progressBar.setProgress(answered);
    }
}
