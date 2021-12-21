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
import logica.Usuario;
import logica.Vendedor;

@WebServlet(name = "SvConsultaVendedores", urlPatterns = {"/SvConsultaVendedores"})
public class SvConsultaVendedores extends HttpServlet {
    ControladoraLogica control = new ControladoraLogica();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Vendedor> listaVendedores = control.traerVendedores();
        HttpSession misession =request.getSession();
        misession.setAttribute("listaVendedores", listaVendedores);
        response.sendRedirect("nuestrosVendedores.jsp");
        //response.sendRedirect("admVendedores.jsp"); //PRUEBA
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
