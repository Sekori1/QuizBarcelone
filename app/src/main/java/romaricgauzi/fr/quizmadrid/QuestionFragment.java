package romaricgauzi.fr.quizmadrid;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private QuestionListAdapter mAdapter;
    private QuestionGroup questionGroup;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question, container, false);

        Integer i = null;
        try {
            i = getArguments().getInt("Q");
            Log.d("FRAG", "receive" + i);
            questionGroup = Home.getQuestionGroup(i);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (questionGroup != null) {
            mRecyclerView = view.findViewById(R.id.recyclerview);
            mAdapter = new QuestionListAdapter(view.getContext(), questionGroup);
            mRecyclerView.setAdapter(mAdapter);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        }
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        mAdapter.notifyDataSetChanged();
    }
}
