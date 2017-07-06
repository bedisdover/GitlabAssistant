package cn.edu.nju.bedisdover.gitlabassistant.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by song on 17-7-5.
 */
public class Item implements Serializable {

    private int id;

    private String title;

    private String description;

    private String startAt;

    private String endAt;

    private List<Question> questions;

    private int course;

    private String status;

    private String currentTime;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getStartAt() {
        return startAt;
    }

    public String getEndAt() {
        return endAt;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public int getCourse() {
        return course;
    }

    public String getStatus() {
        return status;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", startAt=" + startAt +
                ", endAt=" + endAt +
                ", questions=" + questions +
                ", course=" + course +
                ", status='" + status + '\'' +
                ", currentTime=" + currentTime +
                '}';
    }
}
