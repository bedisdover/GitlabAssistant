package cn.edu.nju.bedisdover.gitlabassistant.view;

import android.app.Application;

import android.util.Base64;
import cn.edu.nju.bedisdover.gitlabassistant.model.User;

import java.util.Arrays;

/**
 * Created by doversong on 2017/7/2.
 *
 * 全局application
 */
public class MyApplication extends Application {

    /**
     * 请求接口url
     */
    public static final String BASE_URL = "http://115.29.184.56:8090/api";

    public static String AUTH;

    private static MyApplication instance;

    private User user;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = new MyApplication();
    }

    public static MyApplication getInstance() {
        return instance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static String getToken() {
        return "Basic " + new String(Base64.encode(AUTH.getBytes(), Base64.DEFAULT)).replaceAll("\n", "");
    }
}
