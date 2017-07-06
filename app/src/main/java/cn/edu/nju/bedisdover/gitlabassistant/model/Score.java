package cn.edu.nju.bedisdover.gitlabassistant.model;

import java.io.Serializable;

/**
 * Created by song on 17-7-6.
 */
public class Score implements Serializable {

    private int studentId;
    private String studentName;
    private String studentNumber;
    private int score;
    private boolean scored;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isScored() {
        return scored;
    }

    public void setScored(boolean scored) {
        this.scored = scored;
    }

    @Override
    public String toString() {
        return "studentId: " + studentId +
                "\nstudentName: '" + studentName + '\'' +
                "\nstudentNumber: '" + studentNumber + '\'' +
                "\nscore: " + score +
                "\nscored: " + scored;
    }
}
