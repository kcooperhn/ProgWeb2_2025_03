package hn.uth.servletbootstrap;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "servletDos", value = "/servlet-dos")
public class ServletDos extends HttpServlet {
    private String message;

    public void init() {
        message = "Prueba desde un Servlet SIN bootstap";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        // Hello
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");

        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>Servlet - Formulario de Usuario</title>");
        out.println("</head>");

        out.println("<body>");
        out.println("<div class=\"container\">");
        out.println("<div class=\"alert alert-info\" role=\"alert\">" +  message +  "</div>");
        out.println("</div>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}