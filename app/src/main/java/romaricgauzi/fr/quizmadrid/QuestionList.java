package romaricgauzi.fr.quizmadrid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class QuestionList extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private QuestionListAdapter mAdapter;
    private QuestionGroup questionGroup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_list);

        questionGroup = HomelessnessList.getQuestionGroup(getIntent());

        if(questionGroup != null){
            mRecyclerView = findViewById(R.id.recyclerview);
            mAdapter = new QuestionListAdapter(this, questionGroup);
            mRecyclerView.setAdapter(mAdapter);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        }else{
            finish();
        }
    }

}
