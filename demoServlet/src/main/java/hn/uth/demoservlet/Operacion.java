package hn.uth.demoservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "Operacion", value = "/Operacion")
public class Operacion extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doOperation( request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doOperation( request, response);
    }

    private void doOperation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Configurar el tipo de contenido y codificación
        response.setCharacterEncoding("UTF-8");

        String numero1 = request.getParameter("n1");
        String numero2 = request.getParameter("n2");

        try{
            int resultado = Integer.parseInt(numero1) + Integer.parseInt(numero2);
            response.getWriter().println("El resultado es: " + resultado);
        }catch(Exception e){
            response.getWriter().println("Debes de ingresar dos numeros validos.");
            e.printStackTrace();
        }
    }
}