/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ricardo
 */
@WebServlet(name = "CicloVida", urlPatterns = {"/ciclo"})
public class CicloVida extends HttpServlet {

    @Override
    public void init(ServletConfig config) {
        System.out.println("init()");
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Service()");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Parametrosn</title>");  
            out.println("<link rel='stylesheet' href='css/estilo.css' />");
            out.println("</head>");
            out.println("<body>");
            out.println("<p><a href=\"index.html\">Volver al inicio</a></p>");
            out.println("<h1>Servlet Par&aacute;metros at " + request.getContextPath() + "</h1>");
            java.util.Enumeration<String> parametros = request.getParameterNames();
            while(parametros.hasMoreElements()){
                String parametro = parametros.nextElement();
                out.println("<p><b>" +parametro +": </b>" +request.getParameter(parametro) +"</p></br>");          
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    public void destroy() {
        System.out.println("destroy()");
    }
}
