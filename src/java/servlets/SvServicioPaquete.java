package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.ControladoraLogica;
import logica.Servicio;
import logica.TipoServicio;

@WebServlet(name = "SvServicioPaquete", urlPatterns = {"/SvServicioPaquete"})
public class SvServicioPaquete extends HttpServlet {
    ControladoraLogica control = new ControladoraLogica();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Servicio> listaServicios = control.traerServicios();
        HttpSession misession =request.getSession();
        misession.setAttribute("listaServicios", listaServicios);
        response.sendRedirect("altaPaquete.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
