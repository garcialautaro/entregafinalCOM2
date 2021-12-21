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

@WebServlet(name = "SvAdmUsuarios", urlPatterns = {"/SvAdmUsuarios"})
public class SvAdmUsuarios extends HttpServlet {
    ControladoraLogica control = new ControladoraLogica();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Usuario> listaUsuarios = control.traerUsuarios();
        HttpSession misession =request.getSession();
        misession.setAttribute("listaUsuarios", listaUsuarios);
        response.sendRedirect("admUsuarios.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
