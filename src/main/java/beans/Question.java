package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import servlets.ServletUtilities;

@SuppressWarnings("unused")
public class Question implements Serializable {
    private int difficulty;
    private String question;
    private int correctAnswer;
    private List<String> answers = new ArrayList<>();
    private String answer1, answer2, answer3, answer4;

    public Question() {
        int i = 0;
        while (i < 4) {
            i++;
            answers.add(null);
        }
    }

    public int getCorrectAnswer() {
        return this.correctAnswer;
    }

    public void setCorrectAnswer(int answer) {
        this.correctAnswer = answer <= 4 ? answer : 0;
    }

    public void setQuestion(String question) {
        this.question = ServletUtilities.filter(question);
    }

    public String getQuestion() {
        return this.question;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = (difficulty <= 4 ? difficulty : 0);
    }

    public int getDifficulty() {
        return this.difficulty;
    }

    public void setAnswer1(String answer) {
        if (answer != null) {
            addAnswer(answer, 0);
        }
    }

    public void setAnswer2(String answer) {
        if (answer != null) {
            addAnswer(answer, 1);
        }
    }

    public void setAnswer3(String answer) {
        if (answer != null) {
            addAnswer(answer, 2);
        }
    }

    public void setAnswer4(String answer) {
        if (answer != null) {
            addAnswer(answer, 3);
        }
    }

    public void addAnswer(String answer, Integer pos) {
        if (pos < 4) {
            this.answers.set(pos, ServletUtilities.filter(answer));
        }
    }

    public List<String> getAnswers() {
        return this.answers;
    }


    public String getAnswer(int pos) {
        return this.answers.get(pos);
    }

    public String display() {
        StringBuffer details = new StringBuffer("<pre>");

        details.append(this.question).append("?<br>Difficulty: ")
                .append(this.difficulty).append("<br>Answers   : (")
                .append(this.answers.get(0)).append(", ")
                .append(this.answers.get(1)).append(", ")
                .append(this.answers.get(2)).append(", ")
                .append(this.answers.get(3)).append(")<br>Correct A.: ")
                .append(this.answers.get(this.correctAnswer)).append("<br></pre>");

        return details.toString();
    }


    public boolean isComplete() {

        if (this.question == null) {
            return false;
        }
        if (this.answers.size() != 4) {
            return false;
        }
        for (String q : this.answers) {
            if (q == null) {
                return false;
            }
        }

        return true;
    }

}