package cn.edu.nju.bedisdover.gitlabassistant.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.edu.nju.bedisdover.gitlabassistant.R;
import cn.edu.nju.bedisdover.gitlabassistant.model.Group;
import cn.edu.nju.bedisdover.gitlabassistant.view.MyApplication;
import cn.edu.nju.bedisdover.gitlabassistant.view.activity.GroupActivity;
import cn.edu.nju.bedisdover.gitlabassistant.view.adapter.GroupAdapter;
import com.google.gson.Gson;
import com.koushikdutta.ion.Ion;

/**
 * Created by song on 17-7-6.
 */
public class GroupFragment extends Fragment {

    @BindView(R.id.lv_group)
    ListView lv_group;

    private Group[] mGroups;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_group, container, false);

        ButterKnife.bind(this, view);

        init();
        loadData();

        return view;
    }

    private void init() {
        lv_group.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent intent = new Intent(getContext(), GroupActivity.class);

            intent.putExtra("group", mGroups[i]);

            startActivity(intent);
        });
    }

    private void loadData() {
        Ion.with(this)
                .load(MyApplication.BASE_URL + "/group")
                .setHeader("Authorization", MyApplication.getToken())
                .asJsonArray()
                .setCallback((e, result) -> {
                    if (result != null) {
                        mGroups = new Gson().fromJson(result, Group[].class);

                        lv_group.setAdapter(new GroupAdapter(getContext(), mGroups));
                    }
                });
    }
}
