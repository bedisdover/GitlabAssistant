package cn.edu.nju.bedisdover.gitlabassistant.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.edu.nju.bedisdover.gitlabassistant.R;
import cn.edu.nju.bedisdover.gitlabassistant.model.Item;
import cn.edu.nju.bedisdover.gitlabassistant.view.MyApplication;
import cn.edu.nju.bedisdover.gitlabassistant.view.activity.AnalyseActivity;
import cn.edu.nju.bedisdover.gitlabassistant.view.activity.ScoreActivity;
import cn.edu.nju.bedisdover.gitlabassistant.view.adapter.ItemAdapter;
import com.google.gson.Gson;
import com.koushikdutta.ion.Ion;

/**
 * Created by doversong on 2017/7/1.
 */
public class TeacherFragment extends Fragment {

    @BindView(R.id.lv_item)
    ListView lv_item;

    private Item[] mItems;

    private String url;

    public TeacherFragment(String url) {
        super();
        this.url = url;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student, container, false);

        ButterKnife.bind(this, view);

        init();

        return view;
    }

    private void init() {
        loadData();

        lv_item.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent intent = new Intent(getContext(), ScoreActivity.class);

            intent.putExtra("item", mItems[i]);

            startActivity(intent);
        });
    }

    private void loadData() {
        Ion.with(this)
                .load(MyApplication.BASE_URL + url)
                .setHeader("Authorization", MyApplication.getToken())
                .asJsonArray()
                .setCallback((e, result) -> {
                    if (result != null) {
                        mItems = new Gson().fromJson(result, Item[].class);

                        lv_item.setAdapter(new ItemAdapter(getContext(), mItems));
                    }
                });
    }
}
