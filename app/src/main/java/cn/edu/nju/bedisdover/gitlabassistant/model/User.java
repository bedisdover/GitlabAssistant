package cn.edu.nju.bedisdover.gitlabassistant.model;

import java.io.Serializable;

/**
 * Created by doversong on 2017/6/25.
 *
 * User 对象
 */
public class User implements Serializable {

    private int id;

    private String username;

    private String name;

    private String type;

    private String avatar;

    private String gender;

    private String email;

    private int schoolId;

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public int getSchoolId() {
        return schoolId;
    }

    @Override
    public String toString() {
        return "id: " + id +
                "\nusername: " + username + '\'' +
                "\nname: " + name + '\'' +
                "\ntype: " + type + '\'' +
                "\navatar: " + avatar + '\'' +
                "\ngender: " + gender + '\'' +
                "\nemail: " + email + '\'' +
                "\nschoolId:  " + schoolId;
    }
}
