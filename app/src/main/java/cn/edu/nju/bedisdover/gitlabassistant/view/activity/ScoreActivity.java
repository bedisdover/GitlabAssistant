package cn.edu.nju.bedisdover.gitlabassistant.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.edu.nju.bedisdover.gitlabassistant.R;
import cn.edu.nju.bedisdover.gitlabassistant.model.Item;
import cn.edu.nju.bedisdover.gitlabassistant.model.Score;
import cn.edu.nju.bedisdover.gitlabassistant.view.MyApplication;
import cn.edu.nju.bedisdover.gitlabassistant.view.adapter.StudentAdapter;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;
import java.util.List;

public class ScoreActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.lv_score)
    ListView lv_score;

    private Score[] mScores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        ButterKnife.bind(this);

        init();

        loadData();
    }

    private void init() {
        Item mItem = (Item) getIntent().getSerializableExtra("item");

        toolbar.setTitle(mItem.getTitle());
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());
    }

    private void loadData() {
        Ion.with(this)
                .load(MyApplication.BASE_URL + "/assignment/" + 12 + "/score")
                .setHeader("Authorization", MyApplication.getToken())
                .asJsonObject()
                .setCallback((e, result) -> {
                    if (result != null) {
                        JsonArray questions = result.get("questions").getAsJsonArray();

                        if (questions == null || questions.size() == 0) {
                            Toast.makeText(this, "无数据", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        List<Score> scoreList = new ArrayList<>();
                        Gson gson = new Gson();
                        for (int i = 0; i < questions.size(); i++) {
                            scoreList.addAll(gson.fromJson(questions.get(i).getAsJsonObject().get("students"), new TypeToken<List<Score>>() {
                            }.getType()));
                        }

                        mScores = new Score[scoreList.size()];
                        mScores = scoreList.toArray(mScores);

                        lv_score.setAdapter(new StudentAdapter(ScoreActivity.this, mScores));
                    }
                });
    }
}
