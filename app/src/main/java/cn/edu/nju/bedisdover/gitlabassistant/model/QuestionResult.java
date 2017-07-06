package cn.edu.nju.bedisdover.gitlabassistant.model;

import java.io.Serializable;

/**
 * Created by song on 17-7-6.
 */
public class QuestionResult implements Serializable {

    private int questionId;
    private String questionTitle;
    private MetricData metricData;
    private TestResult testResult;
    private ScoreResult scoreResult;

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public MetricData getMetricData() {
        return metricData;
    }

    public void setMetricData(MetricData metricData) {
        this.metricData = metricData;
    }

    public TestResult getTestResult() {
        return testResult;
    }

    public void setTestResult(TestResult testResult) {
        this.testResult = testResult;
    }

    public ScoreResult getScoreResult() {
        return scoreResult;
    }

    public void setScoreResult(ScoreResult scoreResult) {
        this.scoreResult = scoreResult;
    }

    @Override
    public String toString() {
        return "\nquestionId:  " + questionId +
                "\nquestionTitle='" + questionTitle + '\'' +
                "\nmetricData:  " + metricData +
                "\ntestResult:  " + testResult +
                "\nscoreResult:  " + scoreResult;
    }

    public static class MetricData implements Serializable {

        private String git_url;
        private boolean measured;
        private int total_line_count;
        private int comment_line_count;
        private int field_count;
        private int method_count;
        private int max_coc;

        public String getGit_url() {
            return git_url;
        }

        public void setGit_url(String git_url) {
            this.git_url = git_url;
        }

        public boolean isMeasured() {
            return measured;
        }

        public void setMeasured(boolean measured) {
            this.measured = measured;
        }

        public int getTotal_line_count() {
            return total_line_count;
        }

        public void setTotal_line_count(int total_line_count) {
            this.total_line_count = total_line_count;
        }

        public int getComment_line_count() {
            return comment_line_count;
        }

        public void setComment_line_count(int comment_line_count) {
            this.comment_line_count = comment_line_count;
        }

        public int getField_count() {
            return field_count;
        }

        public void setField_count(int field_count) {
            this.field_count = field_count;
        }

        public int getMethod_count() {
            return method_count;
        }

        public void setMethod_count(int method_count) {
            this.method_count = method_count;
        }

        public int getMax_coc() {
            return max_coc;
        }

        public void setMax_coc(int max_coc) {
            this.max_coc = max_coc;
        }

        @Override
        public String toString() {
            return "MetricData{" +
                    "\ngit_url='" + git_url + '\'' +
                    "\nmeasured:  " + measured +
                    "\ntotal_line_count:  " + total_line_count +
                    "\ncomment_line_count:  " + comment_line_count +
                    "\nfield_count:  " + field_count +
                    "\nmethod_count:  " + method_count +
                    "\nmax_coc:  " + max_coc +
                    '}';
        }
    }

    public static class TestResult implements Serializable {

        private String git_url;
        private boolean compile_succeeded;
        private boolean tested;
        private Object testcases;

        public String getGit_url() {
            return git_url;
        }

        public void setGit_url(String git_url) {
            this.git_url = git_url;
        }

        public boolean isCompile_succeeded() {
            return compile_succeeded;
        }

        public void setCompile_succeeded(boolean compile_succeeded) {
            this.compile_succeeded = compile_succeeded;
        }

        public boolean isTested() {
            return tested;
        }

        public void setTested(boolean tested) {
            this.tested = tested;
        }

        public Object getTestcases() {
            return testcases;
        }

        public void setTestcases(Object testcases) {
            this.testcases = testcases;
        }

        @Override
        public String toString() {
            return "TestResult{" +
                    "\ngit_url='" + git_url + '\'' +
                    "\ncompile_succeeded:  " + compile_succeeded +
                    "\ntested:  " + tested +
                    "\ntestcases:  " + testcases +
                    '}';
        }
    }

    public static class ScoreResult implements Serializable {

        private String git_url;
        private int score;
        private boolean scored;

        public String getGit_url() {
            return git_url;
        }

        public void setGit_url(String git_url) {
            this.git_url = git_url;
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
            return "ScoreResult{" +
                    "\ngit_url='" + git_url + '\'' +
                    "\nscore:  " + score +
                    "\nscored:  " + scored +
                    '}';
        }
    }
}
