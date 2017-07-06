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
import com.google.gson.JsonElement;
import com.koushikdutta.ion.Ion;

public class ScoreActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.lv_score)
    ListView lv_score;

    private Item mItem;

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
        mItem = (Item) getIntent().getSerializableExtra("item");

        toolbar.setTitle(mItem.getTitle());
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());
    }

    private void loadData() {
        Ion.with(this)
                .load(MyApplication.BASE_URL + "/assignment/" + mItem.getId() + "/score")
                .setHeader("Authorization", MyApplication.getToken())
                .asJsonObject()
                .setCallback((e, result) -> {
                    if (result != null) {
                        JsonArray questions = result.get("questions").getAsJsonArray();

                        if (questions == null || questions.size() == 0) {
                            Toast.makeText(this, "无数据", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        JsonElement scores = questions.get(0).getAsJsonObject().get("students");
                        if (scores == null) {
                            Toast.makeText(this, "无数据", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        mScores = new Gson().fromJson(scores, Score[].class);

                        lv_score.setAdapter(new StudentAdapter(ScoreActivity.this, mScores));
                    }
                });
    }
}
