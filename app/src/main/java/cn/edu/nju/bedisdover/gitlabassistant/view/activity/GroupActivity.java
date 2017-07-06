package cn.edu.nju.bedisdover.gitlabassistant.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.edu.nju.bedisdover.gitlabassistant.R;
import cn.edu.nju.bedisdover.gitlabassistant.model.Group;
import cn.edu.nju.bedisdover.gitlabassistant.model.Student;
import cn.edu.nju.bedisdover.gitlabassistant.view.MyApplication;
import cn.edu.nju.bedisdover.gitlabassistant.view.adapter.StudentAdapter;
import com.google.gson.Gson;
import com.koushikdutta.ion.Ion;

public class GroupActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.lv_student)
    ListView lv_student;

    private Group mGroup;

    private Student[] mStudents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        ButterKnife.bind(this);

        init();
        loadData();
    }

    private void init() {
        mGroup = (Group) getIntent().getSerializableExtra("group");

        toolbar.setTitle(mGroup.getName());
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());
    }

    private void loadData() {
        Ion.with(this)
                .load(MyApplication.BASE_URL + "/group/" + mGroup.getId() + "/students")
                .setHeader("Authorization", MyApplication.getToken())
                .asJsonArray()
                .setCallback((e, result) -> {
                    if (result != null) {
                        mStudents = new Gson().fromJson(result, Student[].class);

                        lv_student.setAdapter(new StudentAdapter(GroupActivity.this, mStudents));
                    }
                });
    }
}
