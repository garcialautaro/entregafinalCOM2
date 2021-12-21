package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.ControladoraLogica;

@WebServlet(name = "SvEliminarVendedor", urlPatterns = {"/SvEliminarVendedor"})
public class SvEliminarVendedor extends HttpServlet {
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
        Integer id = Integer.parseInt(request.getParameter("idVendedor"));
        control.borrarVendedor(id);
        //actualizo lista
        request.getSession().setAttribute("listaVendedores", control.traerVendedores());
        response.sendRedirect("admVendedores.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
