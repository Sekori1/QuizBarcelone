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

    public QuestionListAdapter(Context context, QuestionGroup questionGroup) {
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
        final QuestionProfil questionProfil = questionGroup.getQuestionProfils()[id];

        int r = questionGroup.getAnswereOf(id);

        Log.d("TEST","BUILD QUESTION ID "  + id + " , ANSWER ID " + r);

        View view = holder.getView();
        ImageView imageView = holder.getImageView();
        if(r != 0)imageView.setColorFilter(view.getResources().getColor(R.color.colorPrimaryDark));
            else imageView.setColorFilter(view.getResources().getColor(R.color.grey));
        final TextView textView = holder.getQuestionTitle();
        textView.setText("Question " + (id+1));
        view.setOnClickListener(new View.OnClickListener() {
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
        private View view;
        final QuestionListAdapter mAdapter;

        public QuestionViewHolder(View itemView, QuestionListAdapter adapter) {
            super(itemView);
            view = itemView;
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

        public View getView() {
            return view;
        }
    }
}