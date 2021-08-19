package com.tarnet.servlets;

import com.tarnet.deneme.dao.UserRepository;
import com.tarnet.deneme.domain.User;
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

        UserRepository userRepository = applicationContext.getBean(UserRepository.class);

        List<User> usersList = userRepository.list();


        PrintWriter printWriter = new PrintWriter(resp.getOutputStream());


        printWriter.println("<html>");
        printWriter.println("<h1>");
        printWriter.println("MyServlet.doGet 4");
        printWriter.println("</h1>");


        for (User u: usersList){
            printWriter.println("<ul>");
            printWriter.println("<li>" + u.getAd() +"</li>");
            printWriter.println("</ul>");
        }

        printWriter.println("</html>");

        printWriter.flush();
    }
}