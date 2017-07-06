package cn.edu.nju.bedisdover.gitlabassistant.model;

import java.io.Serializable;

/**
 * Created by song on 17-7-5.
 */
public class Question implements Serializable {

    private int id;

    private String title;

    private String description;

    private String difficulty;

    private String gitUrl;

    private String type;

    private User creator;

    private int duration;

    private int link;

    private String knowledgeVos;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getGitUrl() {
        return gitUrl;
    }

    public String getType() {
        return type;
    }

    public User getCreator() {
        return creator;
    }

    public int getDuration() {
        return duration;
    }

    public int getLink() {
        return link;
    }

    public String getKnowledgeVos() {
        return knowledgeVos;
    }

    @Override
    public String toString() {
        return "id: " + id +
                "\ntitle: '" + title + '\'' +
                "\ndescription: '" + description + '\'' +
                "\ndifficulty: '" + difficulty + '\'' +
                "\ngitUrl: '" + gitUrl + '\'' +
                "\ntype: '" + type + '\'' +
                "\nduration: " + duration +
                "\nlink: " + link +
                "\nknowledgeVos: '" + knowledgeVos + '\'';
    }
}
