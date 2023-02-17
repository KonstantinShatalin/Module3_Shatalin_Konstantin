package servlets;

import beans.BeanUtilities;
import beans.Question;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.mockito.Mockito.*;

public class QuestionFormTest{
    @Test
    public void testDoGet() throws IOException {
        QuestionForm questionForm = new QuestionForm();
        Question question = mock(Question.class);

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);


        when(question.isComplete()).thenReturn(true);

        when(response.getWriter()).thenReturn(new PrintWriter(new StringWriter()));


        questionForm.doGet(request, response);

        when(request.getRequestURI()).thenReturn("/questionForm");


        //verify(response).sendRedirect("addQuestion");


    }
}