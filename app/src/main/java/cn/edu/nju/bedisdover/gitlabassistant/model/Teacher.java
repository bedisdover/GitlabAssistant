package cn.edu.nju.bedisdover.gitlabassistant.model;

/**
 * Created by doversong on 2017/6/25.
 *
 * 老师
 */
public class Teacher extends User {

    private int authority;

    public boolean isAuthoritied() {
        return authority == 1;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "authority=" + authority +
                '}';
    }
}
