package cn.edu.nju.bedisdover.gitlabassistant.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.edu.nju.bedisdover.gitlabassistant.R;
import cn.edu.nju.bedisdover.gitlabassistant.model.QuestionResult;
import cn.edu.nju.bedisdover.gitlabassistant.view.MyApplication;
import com.koushikdutta.ion.Ion;

public class QuestionActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tv_result)
    TextView tv_result;

    @BindView(R.id.tv_readme)
    TextView tv_readme;

    private int assignmentID;

    private QuestionResult questionResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        ButterKnife.bind(this);

        init();
        loadReadme();
    }

    private void init() {
        assignmentID = getIntent().getIntExtra("assignmentID", -1);
        questionResult = (QuestionResult) getIntent().getSerializableExtra("questionResult");

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        tv_result.setText(questionResult.toString());
    }

    private void loadReadme() {
        Ion.with(this)
                .load(MyApplication.BASE_URL + "/assignment/" + "98" + "/student/227/question/" + "26")
                .setHeader("Authorization", MyApplication.getToken())
                .asJsonObject()
                .setCallback((e, result) -> {
                    if (result != null) {
                        if (result.get("content") == null) {
                            tv_readme.setVisibility(View.GONE);
                        } else {
                            tv_readme.setText(result.get("content").getAsString());
                            System.out.println(result.get("content").getAsString());
                        }
                    }
                });
    }
}
