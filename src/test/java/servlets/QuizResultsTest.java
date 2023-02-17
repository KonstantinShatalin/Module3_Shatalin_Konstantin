package servlets;

import org.junit.jupiter.api.Test;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;

import static org.mockito.Mockito.*;

public class QuizResultsTest {

    @Test
    public void testDoPost() throws IOException {
        QuizResults quizResults = new QuizResults();

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);

        when(request.getSession()).thenReturn(session);


        when(request.getCookies())
                .thenReturn(new Cookie[]{
                        new Cookie("userScore", "10"),
                        new Cookie("quizAccessDate", "1")
                });

        when(response.getWriter()).thenReturn(new PrintWriter(new StringWriter()));

        quizResults.doPost(request, response);


        when(request.getRequestURI()).thenReturn("/quizResults");


    }
}