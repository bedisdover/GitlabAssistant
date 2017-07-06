package cn.edu.nju.bedisdover.gitlabassistant.model;

import java.io.Serializable;

/**
 * Created by doversong on 2017/6/25.
 *
 * 学生
 */
public class Student extends User implements Serializable {

    private int gitId;

    private String number;

    private int groupId;

    private String gitUsername;

    public int getGitId() {
        return gitId;
    }

    public String getNumber() {
        return number;
    }

    public int getGroupId() {
        return groupId;
    }

    public String getGitUsername() {
        return gitUsername;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\ngitId: " + gitId +
                "\nnumber: '" + number + '\'' +
                "\ngroupId: " + groupId +
                "\ngitUsername: '" + gitUsername + '\'';
    }
}
