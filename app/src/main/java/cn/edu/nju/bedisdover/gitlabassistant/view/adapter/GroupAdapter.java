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
import cn.edu.nju.bedisdover.gitlabassistant.model.Group;

/**
 * Created by song on 17-7-6.
 * <p>
 * item adapter
 */
public class GroupAdapter extends BaseAdapter {

    private LayoutInflater inflater;

    private Group[] mGroups;

    public GroupAdapter(Context context, Group[] groups) {
        inflater = LayoutInflater.from(context);

        this.mGroups = groups;
    }

    @Override
    public int getCount() {
        return mGroups.length;
    }

    @Override
    public Group getItem(int i) {
        return mGroups[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if (view == null) {
            view = inflater.inflate(R.layout.list_group, viewGroup, false);

            viewHolder = new ViewHolder(view);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.tv_name.setText(getItem(i).getName());

        return view;
    }

    static class ViewHolder {

        @BindView(R.id.tv_name)
        TextView tv_name;

        ViewHolder(View view) {
            super();
            ButterKnife.bind(this, view);
        }
    }
}
