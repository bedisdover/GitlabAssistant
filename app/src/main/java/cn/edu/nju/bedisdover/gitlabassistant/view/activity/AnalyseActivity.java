package cn.edu.nju.bedisdover.gitlabassistant.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.ButterKnife;
import cn.edu.nju.bedisdover.gitlabassistant.R;
import cn.edu.nju.bedisdover.gitlabassistant.model.Item;
import cn.edu.nju.bedisdover.gitlabassistant.model.QuestionResult;
import cn.edu.nju.bedisdover.gitlabassistant.view.MyApplication;
import cn.edu.nju.bedisdover.gitlabassistant.view.adapter.QuestionAdapter;
import com.google.gson.Gson;
import com.koushikdutta.ion.Ion;

public class AnalyseActivity extends AppCompatActivity {

    private LinearLayout ll_header;

    private Item mItem;

    private QuestionResult[] questionResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyse);

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ll_header = (LinearLayout) inflater.inflate(R.layout.list_question_header, null);

        ButterKnife.bind(ll_header);

        init();
        loadData();
    }

    private void init() {
        mItem = (Item) getIntent().getSerializableExtra("item");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(mItem.getTitle());
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        TextView tv_status = (TextView) ll_header.findViewById(R.id.tv_status);
        TextView tv_description = (TextView) ll_header.findViewById(R.id.tv_description);
        TextView tv_start = (TextView) ll_header.findViewById(R.id.tv_start);
        TextView tv_end = (TextView) ll_header.findViewById(R.id.tv_end);

        tv_status.setText("状态:" + mItem.getStatus());
        tv_description.setText("描述:" + mItem.getDescription());
        tv_start.setText("开始时间:" + mItem.getStartAt());
        tv_end.setText("结束时间:" + mItem.getEndAt());

        ListView lv_question = (ListView) findViewById(R.id.lv_question);
        lv_question.setAdapter(new QuestionAdapter(this, mItem.getQuestions()));
        lv_question.addHeaderView(ll_header);

        lv_question.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent intent  = new Intent(AnalyseActivity.this, QuestionActivity.class);

            QuestionResult result = getResult(mItem.getQuestions().get(i - 1).getId());

            if (result == null) {
                Toast.makeText(this, "无数据", Toast.LENGTH_SHORT).show();
                return;
            }

            intent.putExtra("assignmentID", mItem.getId());
            intent.putExtra("questionResult", result);

            startActivity(intent);
        });
    }

    private QuestionResult getResult(int id) {
        for (QuestionResult questionResult : questionResults) {
            if (questionResult.getQuestionId() == id) {
                return questionResult;
            }
        }

        return null;
    }

    private void loadData() {
        Ion.with(this)
                .load(MyApplication.BASE_URL + "/assignment/" + mItem.getId() + "/student/227/analysis")
                .setHeader("Authorization", MyApplication.getToken())
                .asJsonObject()
                .setCallback((e, result) -> {
                    if (result != null) {
                        questionResults = new Gson().fromJson(result.getAsJsonArray("questionResults"), QuestionResult[].class);
                    }
                });
    }
}
