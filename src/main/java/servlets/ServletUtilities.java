package servlets;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.File;

public class ServletUtilities {

    public static File createFile(String path) {
        File file = new File(path);
        if (file.exists()) {
            file.delete();
        }
        return new File(path);
    }

    public static Cookie getCookie(HttpServletRequest request,
                                   String cookieName) {

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookieName.equals(cookie.getName())) {
                    return (cookie);
                }
            }
        }
        return (null);
    }

    public static String getCookieValue(HttpServletRequest request,
                                        String cookieName, String defaultValue) {

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                if (cookieName.equals(cookie.getName())) {
                    return (cookie.getValue());
                }
            }
        }
        return (defaultValue);
    }

    public static String htmlHeader(String title) {

        StringBuffer html = new StringBuffer("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n");

        html.append("<html>\n<head><title>").append(title).append("</title>")
                .append("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\"/></head>\n");

        return html.toString();
    }

    public static int getIntParameter(HttpServletRequest request, String paramName, int defaultValue) {
        String paramString = request.getParameter(paramName);
        int paramValue;
        try {
            paramValue = Integer.parseInt(paramString);
        } catch (Exception nfe) {
            paramValue = defaultValue;
        }
        return paramValue;
    }

    public static double getDoubleParameter(HttpServletRequest request, String paramName, double defaultValue) {
        String paramString = request.getParameter(paramName);
        double paramValue;
        try {
            paramValue = Double.parseDouble(paramString);
        } catch (Exception nfe) {
            paramValue = defaultValue;
        }
        return paramValue;
    }

    public static String filter(String input) {
        if (!hasSpecialChars(input)) {
            return input;
        }
        StringBuilder filtered = new StringBuilder(input.length());

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            switch (c) {
                case '<':
                    filtered.append("&lt;");
                    break;
                case '>':
                    filtered.append("&gt;");
                    break;
                case '"':
                    filtered.append("&quot;");
                    break;
                case '&':
                    filtered.append("&amp;");
                    break;
                default:
                    filtered.append(c);
            }
        }
        return filtered.toString();
    }

    private static boolean hasSpecialChars(String input) {
        boolean flag = false;
        if ((input != null) && (input.length() > 0)) {
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                switch (c) {
                    case '<':
                        flag = true;
                        break;
                    case '>':
                        flag = true;
                        break;
                    case '"':
                        flag = true;
                        break;
                    case '&':
                        flag = true;
                }
            }
        }
        return flag;
    }
}