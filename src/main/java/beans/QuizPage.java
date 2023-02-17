package beans;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import javax.servlet.http.HttpServlet;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public abstract class QuizPage extends HttpServlet {

    private String title = "Quiz Page";
    private String content = "Quiz Page Content";

    public static void questionWriter(String file, List<Question> questions) {
        XStream xs = new XStream(new DomDriver());
        xs.allowTypes(new Class[] {beans.Question.class});

        try {
            ObjectOutputStream outputStream = xs.createObjectOutputStream(new FileWriter(file));
            outputStream.writeObject(questions);
            outputStream.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Question> questionReader(String file) {

        List<Question> questions = null;

        ObjectInputStream inputStream;
        XStream xs = new XStream(new DomDriver());
        xs.allowTypes(new Class[] {beans.Question.class});

        try {
            inputStream = xs.createObjectInputStream(new FileReader(file));
            questions = (List<Question>) inputStream.readObject();

            inputStream.close();
        } catch (ClassNotFoundException | IOException ex) {
            ex.printStackTrace();
        }

        if (questions == null) {
            questions = new ArrayList<>();
        }

        return questions;
    }

    protected void setTitle(String title) {
        this.title = title;
    }

    protected void setContent(String content) {
        this.content = content;
    }

    private String htmlHeader() {
        StringBuffer temp = new StringBuffer("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");

        temp.append("<html>\n<head>\n")
                .append("<meta http-equiv=\"Content-type\" content=\"text/html;charset=UTF-8\">\n")
                .append("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\n")
                .append("<title>").append(this.title).append("</title>\n</head>\n");


        return temp.toString();
    }

    protected String pageContent() {
        StringBuffer temp = new StringBuffer(htmlHeader());
        temp.append("<body>\n<div class=\"main\">").append(pageHeader())
                .append("<div class=\"content\">\n").append(content).append("</div>\n")
                .append(pageFooter()).append("</div>\n</body>\n</html>");

        return temp.toString();
    }

    private String pageHeader() {
        StringBuffer temp = new StringBuffer("<div class=\"header\">\n");

        temp.append("<span class=\"title\">Online Quiz Game</span>")
                .append("<br><span class=\"home\"><a href=\"index.html\">Home</a></span>\n</div>\n");

        return temp.toString();
    }

    private String pageFooter() {
        StringBuffer temp = new StringBuffer("<div class=\"footer\">\n");

        return temp.toString();
    }


    protected String inputElement(String prompt, String name, String value, boolean shouldPrompt) {

        StringBuffer temp = new StringBuffer("<label for=\"");

        temp.append(name.toLowerCase()).append("\">").append(name).append("</label>\n")
                .append("<input type=\"text\" name=\"").append(name.toLowerCase())
                .append("\" id=\"").append(name.toLowerCase()).append("\" ")
                .append("value=\"").append(value).append("\"><br>\n");

        return temp.toString();
    }

    protected String selectOption(String prompt, String name, String value, boolean isSelected) {

        StringBuffer temp = new StringBuffer("<option value=\"");
        temp.append(value).append("\"");

        if (isSelected) {
            temp.append(" select=\"selected\"");
        }

        temp.append(">").append(name).append("</option>\n");

        return temp.toString();
    }

}
