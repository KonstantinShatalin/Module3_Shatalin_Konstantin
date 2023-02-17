package servlets;

import beans.Question;
import beans.QuizPage;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@WebServlet({"/quizServlet"})
public class QuizServlet extends QuizPage {

    List<Question> quiz;
    String quizLocation = "D:/DOWNLOADS/My_project_File";
    String quizFile = quizLocation + "/quiz.xml";
    HashMap<String, Integer> correctAnswers;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        quiz = questionReader(quizFile);

        correctAnswers = new HashMap<>();
        HttpSession session = request.getSession(true);
        StringBuffer questions;

        if (!quiz.isEmpty()) {
            questions = createQuiz();
            session.setAttribute("correctAnswers", correctAnswers);
        } else {
            questions = new StringBuffer("No Quiz Available");
        }

        setTitle("Take The Quiz");
        setContent("<h1>Take the Quiz</h1>\n" + questions);

        response.setContentType("text/html");
        var printWriter = response.getWriter();
        printWriter.println(pageContent());
    }

    private StringBuffer createQuiz() {
        StringBuffer temp = new StringBuffer("<form action='quizResults' method='Post'>\n<fieldset>\n<legend>Quiz</legend>\n");
        int x = 1;
        int i;

        for (Question question : quiz) {

            temp.append("<b><label>Question ").append(x)
                    .append(": ").append(question.getQuestion())
                    .append("?</label></b><br>\n");

            i = 0;
            while (question.getAnswers().size() > i) {

                temp.append("<input type='radio' name='question-").append(x)
                        .append("'").append(" value='").append(i).append("'");

                if (i == 0) {
                    temp.append(" checked");
                }

                temp.append(">\n")
                        .append(question.getAnswer(i)).append("<br>");

                i++;
            }

            correctAnswers.put("question-" + x, question.getCorrectAnswer());
            temp.append("<br>\n");
            x++;
        }

        temp.append("<input type='submit'>\n</fieldset>\n</form>\n");
        return temp;
    }

}