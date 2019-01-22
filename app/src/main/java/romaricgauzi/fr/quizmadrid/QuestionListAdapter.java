package romaricgauzi.fr.quizmadrid;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
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
    public void onBindViewHolder(@NonNull QuestionViewHolder holder, int i) {
        QuestionProfil questionProfil = questionGroup.getQuestionProfils()[i];

        int r = questionGroup.getAnswereOf(i);

        if(r != 0)holder.getImageView().setVisibility(View.VISIBLE);
        holder.getQuestionTitle().setText("Question " + (i+1));
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