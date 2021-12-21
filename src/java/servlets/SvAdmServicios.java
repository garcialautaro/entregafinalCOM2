package servlets;

import java.io.IOException;
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

@WebServlet(name = "SvAdmServicios", urlPatterns = {"/SvAdmServicios"})
public class SvAdmServicios extends HttpServlet {
    ControladoraLogica control = new ControladoraLogica();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Servicio> listaServicios = control.traerServicios();
        List<TipoServicio> listaTipoServicios = control.traerTipoServicios();
        HttpSession misession =request.getSession();
        misession.setAttribute("listaTipoServicios", listaTipoServicios);
        misession.setAttribute("listaServicios", listaServicios);
        response.sendRedirect("admServicio.jsp");
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
