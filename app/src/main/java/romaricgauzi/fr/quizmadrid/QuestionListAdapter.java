package romaricgauzi.fr.quizmadrid;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;


public class QuestionListAdapter extends RecyclerView.Adapter<QuestionListAdapter.QuestionViewHolder> {

    private LayoutInflater mInflater;
    private int groupID;
    private QuestionInfo[] questions;

    public QuestionListAdapter(Context context, int groupID) {
        this.mInflater = LayoutInflater.from(context);
        this.groupID = groupID;
        this.questions = Home.QUESTIONS[groupID];
    }

    @NonNull
    @Override
    public QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mItemView = mInflater.inflate(R.layout.question_item,
                viewGroup, false);
        return new QuestionViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull final QuestionViewHolder holder, final int id) {

        int r = questions[id].getAnswered();

        Log.d("TEST","BUILD QUESTION ID "  + id + " , ANSWER ID " + r);

        View view = holder.getView();
        ImageView imageView = holder.getImageView();
        if(r != -1)imageView.setColorFilter(view.getResources().getColor(R.color.colorPrimaryDark));
            else imageView.setColorFilter(view.getResources().getColor(R.color.grey));
        final TextView textView = holder.getQuestionTitle();
        final TextView textQuestionNumber = holder.getQuestionNumber();
        //textView.setText("Question " + (id+1));
        Groups.find(groupID).changeGroupBackground(textQuestionNumber);
        textQuestionNumber.setText(String.valueOf(id+1));
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                boolean gridView = questions[id].getQuestionOptions().isGridPresentation();
                Intent intent;
                if(!gridView){
                    intent = new Intent(context, Question.class);
                }else{
                    intent = new Intent(context, QuestionGrid.class);
                }
                intent.putExtra(Question.GROUP_ID, groupID);
                intent.putExtra(Question.QUESTION_ID, id);

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return questions.length;
    }

    class QuestionViewHolder extends RecyclerView.ViewHolder {

        private TextView questionTitle;
        private TextView questionNumber;
        private ImageView imageView;
        private View view;
        final QuestionListAdapter mAdapter;

        public QuestionViewHolder(View itemView, QuestionListAdapter adapter) {
            super(itemView);
            view = itemView;
            questionTitle = itemView.findViewById(R.id.question_title);
            questionNumber = itemView.findViewById(R.id.question_number);
            imageView = itemView.findViewById(R.id.check);
            this.mAdapter = adapter;
        }

        public TextView getQuestionTitle() {
            return questionTitle;
        }

        public ImageView getImageView() {
            return imageView;
        }

        public View getView() {
            return view;
        }

        public TextView getQuestionNumber() {
            return questionNumber;
        }
    }
}