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
import logica.TipoServicio;

@WebServlet(name = "SvTipoServicioAltaServicio", urlPatterns = {"/SvTipoServicioAltaServicio"})
public class SvTipoServicioAltaServicio extends HttpServlet {
    ControladoraLogica control = new ControladoraLogica();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<TipoServicio> listaTipoServicios = control.traerTipoServicios();
        HttpSession misession =request.getSession();
        misession.setAttribute("listaTipoServicios", listaTipoServicios);
        response.sendRedirect("altaServicio.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
