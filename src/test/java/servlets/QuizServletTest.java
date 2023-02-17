package servlets;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.mockito.Mockito.*;

public class QuizServletTest {

    @Test
    public void testDoGet() throws IOException {
        QuizServlet quizServlet = new QuizServlet();

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);

        when(request.getSession()).thenReturn(session);


        when(response.getWriter()).thenReturn(new PrintWriter(new StringWriter()));

        quizServlet.doGet(request, response);


        when(request.getRequestURI()).thenReturn("/quizServlet");

    }
}