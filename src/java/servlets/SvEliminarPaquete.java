package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.ControladoraLogica;

@WebServlet(name = "SvEliminarPaquete", urlPatterns = {"/SvEliminarPaquete"})
public class SvEliminarPaquete extends HttpServlet {
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
        //Traigo el id
        Integer id = Integer.parseInt(request.getParameter("idPaquete"));
        control.borrarPaquete(id);
        //actualizo lista
        request.getSession().setAttribute("listaPaquetes", control.traerPaquetes());
        response.sendRedirect("admPaquete.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
