package servlets;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class QuestionSetterTest {

    @Test
    public void testDoGet() throws IOException {
        QuestionSetter questionSetter = new QuestionSetter();

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(response.getWriter()).thenReturn(new PrintWriter(new StringWriter()));

        questionSetter.doGet(request, response);

        when(request.getRequestURI()).thenReturn("/addQuestion");


    }
}