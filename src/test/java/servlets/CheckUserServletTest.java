package servlets;

import org.junit.jupiter.api.Test;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.mockito.Mockito.*;

public class CheckUserServletTest {

    @Test
    public void testDoGet() throws IOException {
        CheckUserServlet checkUserServlet = new CheckUserServlet();

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getCookies())
                .thenReturn(new Cookie[]{
                        new Cookie("userScore", "10"),
                        new Cookie("quizAccessDate", "1")
                });

        when(response.getWriter()).thenReturn(new PrintWriter(new StringWriter()));

        checkUserServlet.doGet(request, response);




        when(request.getRequestURI()).thenReturn("/playTheQuiz");

        verify(response).sendRedirect("quizServlet");
    }
}