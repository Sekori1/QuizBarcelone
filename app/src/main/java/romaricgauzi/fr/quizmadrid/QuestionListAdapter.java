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


public class QuestionListAdapter extends RecyclerView.Adapter<QuestionListAdapter.QuestionViewHolder> {

    private LayoutInflater mInflater;
    private QuestionGroup questionGroup;

    public QuestionListAdapter(QuestionList context, QuestionGroup questionGroup) {
        this.mInflater = LayoutInflater.from(context);
        this.questionGroup = questionGroup;
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
        Log.d("TEST","BUILD QUESTION ID "  + id);
        final QuestionProfil questionProfil = questionGroup.getQuestionProfils()[id];

        int r = questionGroup.getAnswereOf(id);

        if(r != 0)holder.getImageView().setVisibility(View.VISIBLE);
        final TextView textView = holder.getQuestionTitle();
        textView.setText("Question " + (id+1));
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, Question.class);

                intent.putExtra(Question.QUESTION_MESSAGE, questionProfil.getQuestion());
                intent.putExtra(Question.REPLY_MESSAGE, questionProfil.getReply());
                intent.putExtra(Question.QUESTION_GROUP_ID_MESSAGE, questionGroup.getId());
                intent.putExtra(Question.QUESTION_ID_MESSAGE, id);

                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return questionGroup.getQuestionProfils().length;
    }

    class QuestionViewHolder extends RecyclerView.ViewHolder {

        private TextView questionTitle;
        private ImageView imageView;
        final QuestionListAdapter mAdapter;

        public QuestionViewHolder(View itemView, QuestionListAdapter adapter) {
            super(itemView);
            questionTitle = itemView.findViewById(R.id.question_title);
            imageView = itemView.findViewById(R.id.check);
            this.mAdapter = adapter;
        }

        public TextView getQuestionTitle() {
            return questionTitle;
        }

        public ImageView getImageView() {
            return imageView;
        }
    }
}