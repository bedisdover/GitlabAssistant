package cn.edu.nju.bedisdover.gitlabassistant.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.widget.EditText;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.edu.nju.bedisdover.gitlabassistant.R;
import cn.edu.nju.bedisdover.gitlabassistant.model.Student;
import cn.edu.nju.bedisdover.gitlabassistant.model.Teacher;
import cn.edu.nju.bedisdover.gitlabassistant.view.MyApplication;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.koushikdutta.ion.Ion;

public class LoginActivity extends Activity {

    @BindView(R.id.til_username)
    TextInputLayout til_username;

    @BindView(R.id.til_password)
    TextInputLayout til_password;

    @BindView(R.id.et_username)
    EditText et_username;

    @BindView(R.id.et_password)
    EditText et_password;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        et_username.clearFocus();

        addListeners();
    }

    private void addListeners() {
        et_username.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                til_username.setErrorEnabled(false);
            }
        });

        et_password.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                til_password.setErrorEnabled(false);
            }
        });
    }

    @OnClick(R.id.btn_login)
    void login() {
        String username = et_username.getText().toString();
        String password = et_password.getText().toString();

//        username = "nanguangtailang";
//        username = "liuqin";
//        password = "123";

        if ("".equals(username)) {
            til_username.setError("用户名不能为空");
        }

        if ("".equals(password)) {
            til_password.setError("密码不能为空");
            return;
        }

        JsonObject params = new JsonObject();
        params.addProperty("username", username);
        params.addProperty("password", password);

        Ion.with(this)
                .load(MyApplication.BASE_URL + "/user/auth")
                .setJsonObjectBody(params)
                .asJsonObject()
                .setCallback((e, result) -> {
                    if (result != null) {
                        handleResult(result);

                        MyApplication.AUTH = username + ":" + password;
                    }
                });
    }

    private void handleResult(JsonObject result) {
        if (!result.has("type")) {
            Toast.makeText(this, "网络异常", Toast.LENGTH_SHORT).show();

            return;
        }

        if ("student".equals(result.get("type").getAsString())) {
            Student student = new Gson().fromJson(result, Student.class);

            Intent intent = new Intent(this, StudentActivity.class);
            intent.putExtra("student", student);
            startActivity(intent);
        } else if ("teacher".equals(result.get("type").getAsString())) {
            Teacher teacher = new Gson().fromJson(result, Teacher.class);

            Intent intent = new Intent(this, TeacherActivity.class);
            intent.putExtra("teacher", teacher);
            startActivity(intent);
        }
    }
}
