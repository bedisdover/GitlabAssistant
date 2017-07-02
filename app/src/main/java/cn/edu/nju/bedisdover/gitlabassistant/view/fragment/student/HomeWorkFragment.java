package cn.edu.nju.bedisdover.gitlabassistant.view.fragment.student;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.test.mock.MockApplication;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.koushikdutta.ion.Ion;

import cn.edu.nju.bedisdover.gitlabassistant.R;
import cn.edu.nju.bedisdover.gitlabassistant.view.MyApplication;

/**
 * Created by doversong on 2017/7/1.
 *
 * 作业
 */
public class HomeWorkFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_homework, container, false);

        init();

        return view;
    }

    private void init() {
        createView();

        loadData();
    }

    private void createView() {

    }

    private void loadData() {
        Ion.with(this)
                .load(MyApplication.BASE_URL + "/course/{courseId}/homework")
                .asJsonObject()
                .setCallback((e, result) -> {
                    if (result != null) {

                    }
                });
    }
}
