package cn.edu.nju.bedisdover.gitlabassistant.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.koushikdutta.ion.Ion;

import cn.edu.nju.bedisdover.gitlabassistant.R;
import cn.edu.nju.bedisdover.gitlabassistant.model.Student;
import cn.edu.nju.bedisdover.gitlabassistant.model.Teacher;
import cn.edu.nju.bedisdover.gitlabassistant.view.MyApplication;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout til_username, til_password;

    private EditText et_username, et_password;

    private Button btn_login;

    private String mUsername, mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        createView();
        addListeners();
    }

    private void createView() {
        til_username = (TextInputLayout) findViewById(R.id.til_username);
        til_password = (TextInputLayout) findViewById(R.id.til_password);

        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);

        et_username.clearFocus();

        btn_login = (Button) findViewById(R.id.btn_login);
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

        btn_login.setOnClickListener(e -> login());
    }

    private void login() {
        mUsername = et_username.getText().toString();
        mPassword = et_password.getText().toString();

        if ("".equals(mUsername)) {
            til_username.setError("用户名不能为空");
        }

        if ("".equals(mPassword)) {
            til_password.setError("密码不能为空");
            return;
        }

        JsonObject params = new JsonObject();
        params.addProperty("username", mUsername);
        params.addProperty("password", mPassword);

        Ion.with(this)
                .load(MyApplication.BASE_URL + "/user/auth")
                .setJsonObjectBody(params)
                .asJsonObject()
                .setCallback((e, result) -> {
                    if (result != null) {
                        handleResult(result);
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
