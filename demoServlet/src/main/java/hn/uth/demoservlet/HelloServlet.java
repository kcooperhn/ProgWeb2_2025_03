package hn.uth.demoservlet;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Configurar el tipo de contenido y codificación
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");

            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("<title>Servlet - Formulario de Usuario</title>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; max-width: 600px; margin: 50px auto; padding: 20px; }");
            out.println("h1 { color: #333; text-align: center; }");
            out.println("form { background: #f4f4f4; padding: 20px; border-radius: 8px; }");
            out.println("label { display: block; margin: 10px 0 5px; font-weight: bold; }");
            out.println("input, select { width: 100%; padding: 8px; margin-bottom: 15px; border: 1px solid #ddd; border-radius: 4px; }");
            out.println("button { background: #007bff; color: white; padding: 10px 20px; border: none; border-radius: 4px; cursor: pointer; }");
            out.println("button:hover { background: #0056b3; }");
            out.println(".info { background: #e9ecef; padding: 15px; border-radius: 4px; margin-bottom: 20px; }");

            out.println("</head>");
            out.println("<body>");

            out.println("<div class='info'>");
            out.println("<h1>🚀 Ejemplo de Servlet con Tomcat</h1>");
            out.println("<p><strong>Servlet:</strong> " + this.getClass().getSimpleName() + "</p>");
            out.println("<p><strong>Método: doGet()</p>");
            out.println("<p><strong>Fecha y hora:</strong> " +
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + "</p>");
            out.println("</div>");

            out.println("<form action='" + request.getContextPath() + "/procesar-usuario' method='POST'>");
            out.println("<h2>Registro de Usuario</h2>");

            out.println("<label for='nombre'>Nombre completo:</label>");
            out.println("<input type='text' id='nombre' name='nombre' required>");

            out.println("<label for='email'>Correo electrónico:</label>");
            out.println("<input type='email' id='email' name='email' required>");

            out.println("<label for='edad'>Edad:</label>");
            out.println("<input type='number' id='edad' name='edad' min='1' max='120' required>");

            boolean mostrarCombo = false;
            if(mostrarCombo){
                out.println("<label for='pais'>País:</label>");
                out.println("<select id='pais' name='pais' required>");
                out.println("<option value=''>Selecciona tu país</option>");
                out.println("<option value='Honduras'>Honduras</option>");
                out.println("<option value='Guatemala'>Guatemala</option>");
                out.println("<option value='El Salvador'>El Salvador</option>");
                out.println("<option value='Nicaragua'>Nicaragua</option>");
                out.println("<option value='Costa Rica'>Costa Rica</option>");
                out.println("<option value='Mexico'>México</option>");
                out.println("<option value='Colombia'>Colombia</option>");
                out.println("<option value='España'>España</option>");
                out.println("<option value='Argentina'>Argentina</option>");
                out.println("</select>");
            }

            out.println("<button type='submit'>Procesar Datos</button>");
            out.println("</form>");

            out.println("</body>");
            out.println("</html>");
         }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String tarea = "Tarea: " + request.getParameter("tarea");
        String correo = request.getParameter("correo");
        String telefono = request.getParameter("telefono");
        String metodo = request.getParameter("_method");
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + tarea + "</h1>");
        out.println("<h2>Correo Electrónico:</h2>");
        out.println("<h3>" + correo + "</h3>");
        out.println("<h2>Número de teléfono:</h2>");
        out.println("<h3>" + telefono + "</h3>");
        out.println("<h2>Método:</h2>");
        out.println("<h3>" + metodo + "</h3>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}