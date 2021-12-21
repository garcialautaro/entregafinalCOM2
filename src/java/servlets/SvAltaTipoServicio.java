package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.ControladoraLogica;

@WebServlet(name = "SvAltaTipoServicio", urlPatterns = {"/SvAltaTipoServicio"})
public class SvAltaTipoServicio extends HttpServlet {
    ControladoraLogica control = new ControladoraLogica();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombreTipoServicio = request.getParameter("nombreTipoServicio");
        control.altaTipoServicio(nombreTipoServicio);
        response.sendRedirect("altaTipoServicio.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
