package romaricgauzi.fr.quizmadrid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

public class QuestionList extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private QuestionListAdapter mAdapter;
    private QuestionGroup questionGroup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_list);

        Log.d("TEST", "Create()");

        questionGroup = Home.getQuestionGroup(getIntent());

        if(questionGroup != null){
            mRecyclerView = findViewById(R.id.recyclerview);
            mAdapter = new QuestionListAdapter(this, questionGroup);
            mRecyclerView.setAdapter(mAdapter);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        }else{
            finish();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        mAdapter.notifyDataSetChanged();

        Log.d("TEST", "Start()");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("TEST", "Stop()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TEST", "Pause()");
    }
}
