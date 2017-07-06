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

/**
 * Created by song on 17-7-6.
 * <p>
 * student adapter
 */
public class StudentAdapter extends BaseAdapter {

    private LayoutInflater inflater;

    private Object[] objects;

    public StudentAdapter(Context context, Object[] objects) {
        inflater = LayoutInflater.from(context);

        this.objects = objects;
    }

    @Override
    public int getCount() {
        return objects.length;
    }

    @Override
    public Object getItem(int i) {
        return objects[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if (view == null) {
            view = inflater.inflate(R.layout.list_student, viewGroup, false);

            viewHolder = new ViewHolder(view);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.tv_student.setText(getItem(i).toString());

        return view;
    }

    static class ViewHolder {

        @BindView(R.id.tv_student)
        TextView tv_student;

        ViewHolder(View view) {
            super();
            ButterKnife.bind(this, view);
        }
    }
}
