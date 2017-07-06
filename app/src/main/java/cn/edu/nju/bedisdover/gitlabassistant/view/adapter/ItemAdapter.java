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
import cn.edu.nju.bedisdover.gitlabassistant.model.Item;

/**
 * Created by song on 17-7-6.
 * <p>
 * item adapter
 */
public class ItemAdapter extends BaseAdapter {

    private LayoutInflater inflater;

    private Item[] mItems;

    public ItemAdapter(Context context, Item[] items) {
        inflater = LayoutInflater.from(context);

        this.mItems = items;
    }

    @Override
    public int getCount() {
        return mItems.length;
    }

    @Override
    public Item getItem(int i) {
        return mItems[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if (view == null) {
            view = inflater.inflate(R.layout.list_item, viewGroup, false);

            viewHolder = new ViewHolder(view);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.tv_title.setText(mItems[i].getTitle());
        viewHolder.tv_status.setText(mItems[i].getStatus());
        viewHolder.tv_description.setText(mItems[i].getDescription());
        viewHolder.tv_start.setText(mItems[i].getStartAt());
        viewHolder.tv_end.setText(mItems[i].getEndAt());

        return view;
    }

    static class ViewHolder {

        @BindView(R.id.tv_title)
        TextView tv_title;

        @BindView(R.id.tv_status)
        TextView tv_status;

        @BindView(R.id.tv_description)
        TextView tv_description;

        @BindView(R.id.tv_start)
        TextView tv_start;

        @BindView(R.id.tv_end)
        TextView tv_end;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
