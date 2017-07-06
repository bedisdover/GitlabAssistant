package cn.edu.nju.bedisdover.gitlabassistant.model;

import java.io.Serializable;

/**
 * Created by song on 17-7-6.
 */
public class Group implements Serializable {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
