package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.ControladoraLogica;
import logica.Vendedor;

@WebServlet(name = "SvModificarVendedor", urlPatterns = {"/SvModificarVendedor"})
public class SvModificarVendedor extends HttpServlet {
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
        //traigo id
        Integer id = Integer.parseInt(request.getParameter("idVendedor"));
        Vendedor vend = control.buscarVendedor(id);
        
        HttpSession misession = request.getSession();
        misession.setAttribute("vendedor", vend);
        response.sendRedirect("modificarVendedor.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
