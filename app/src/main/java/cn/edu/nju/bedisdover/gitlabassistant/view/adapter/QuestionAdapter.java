package cn.edu.nju.bedisdover.gitlabassistant.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.edu.nju.bedisdover.gitlabassistant.R;
import cn.edu.nju.bedisdover.gitlabassistant.model.Question;

import java.util.List;

/**
 * Created by song on 17-7-6.
 * <p>
 * question adapter
 */
public class QuestionAdapter extends BaseAdapter {

    private LayoutInflater inflater;

    private List<Question> mQuestion;

    public QuestionAdapter(Context context, List<Question> questions) {
        inflater = LayoutInflater.from(context);

        this.mQuestion = questions;
    }

    @Override
    public int getCount() {
        return mQuestion.size();
    }

    @Override
    public Question getItem(int i) {
        return mQuestion.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if (view == null) {
            view = inflater.inflate(R.layout.list_question, viewGroup, false);

            viewHolder = new ViewHolder(view);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.tv_question.setText(mQuestion.get(i).toString());

        return view;
    }

    static class ViewHolder {

        @BindView(R.id.tv_question)
        TextView tv_question;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
