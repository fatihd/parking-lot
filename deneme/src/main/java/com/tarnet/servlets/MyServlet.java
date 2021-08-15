package com.tarnet.servlets;

import com.tarnet.deneme.MasterRepository;
import com.tarnet.domain.ZzzMaster;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebApplicationContext applicationContext = (WebApplicationContext) req.getServletContext()
                .getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);

        MasterRepository repository = applicationContext.getBean(MasterRepository.class);

        List<ZzzMaster> list = repository.list();


        PrintWriter printWriter = new PrintWriter(resp.getOutputStream());


        printWriter.println("<html>");
        printWriter.println("<h1>");
        printWriter.println("MyServlet.doGet 4");
        printWriter.println("</h1>");

        for (ZzzMaster m: list) {
            printWriter.println("<ul>");
            printWriter.println("<li>" + m.getAd() +"</li>");
            printWriter.println("</ul>");
        }

        printWriter.println("</html>");

        printWriter.flush();
    }
}