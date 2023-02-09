package main.java.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@WebServlet("/main")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
//        resp.sendRedirect("user/privateUser.jsp");
//        resp.sendRedirect("public.jsp");
        try (InputStream resourceAsStream = MainServlet.class.getClassLoader().getResourceAsStream("user/privateUser.jsp");
             DataInputStream dataInputStream = new DataInputStream(resourceAsStream)) {
            resp.getWriter().write(dataInputStream.readUTF());
            System.out.println();
        }


    }
}
