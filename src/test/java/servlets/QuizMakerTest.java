package servlets;

import beans.Question;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

class QuizMakerTest {


    @Test
    public void testDoGet() throws IOException {
        QuizMaker quizMaker = new QuizMaker();
        HttpServletRequest request = mock(HttpServletRequest.class);;
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);


        when(request.getSession(false)).thenReturn(session);
        when(session.getAttribute("questionPosition")).thenReturn(0);
        when(session.getAttribute("questionLevel")).thenReturn(1);
        when(session.getAttribute("quiz")).thenReturn(new ArrayList<Question>());
        quizMaker.doGet(request,response);

        when(request.getParameter("option")).thenReturn("Add");
        when(request.getParameter("option")).thenReturn("Skip");
        when(request.getParameter("option")).thenReturn("Up");
        when(request.getParameter("option")).thenReturn("Finished");

        quizMaker.doGet(request,response);

        when(response.getWriter()).thenReturn(new PrintWriter(new StringWriter()));

        when(request.getRequestURI()).thenReturn("/quizCreator");

        verify(response).sendRedirect("quizCreated.html");

    }
}