package servlets;

import beans.QuizPage;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;


@WebServlet("/playTheQuiz")
public class CheckUserServlet extends QuizPage {

    String quizLocation = "D:/DOWNLOADS/My_project_File";
    String quiz = quizLocation + "/quiz.xml";

    File quizFile = new File(quiz);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String score = ServletUtilities.getCookieValue(request, "userScore", null);
        String quizAccessDate = ServletUtilities.getCookieValue(request, "quizAccessDate", "1");
        HttpSession session = request.getSession();

        var lastModified = quizFile.lastModified();

        if (score == null || (lastModified > Long.parseLong(quizAccessDate))) {
            response.sendRedirect("quizServlet");

            Cookie quizScoreCookie = new Cookie("userScore", null);
            quizScoreCookie.setMaxAge(1);
            response.addCookie(quizScoreCookie);

            return;
        }

        StringBuffer content = new StringBuffer("<h1>Quiz Unavailable</h1>\n");
        content.append("<p>You have already tried this quiz.<br></p>\n")
                .append("Last time you scored: <b>").append(score)
                .append("%</b><br>\n<p>Please wait till a new quiz is created.<br>\n")
                .append("Go back to <a href=\"index.html\">home page</a></p>\n").append("</body>\n</html>\n");

        setTitle("Quiz Results");
        setContent(content.toString());

        response.setContentType("text/html");
        var writer = response.getWriter();
        writer.println(pageContent());
    }

}
