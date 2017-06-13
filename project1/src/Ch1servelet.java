/**
 * Created by zproo on 2017/6/9.
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.io.*;

public class Ch1servelet extends H {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        java.util.Date today = new java.util.Date();
        out.println("<html>"
                + "<body>"
                + "<h1 align=center>Chapter1 Servlet</h1>"
                + "<br>" + today + "</body>" + "</html>"
        );
    }

}
