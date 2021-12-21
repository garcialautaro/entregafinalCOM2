package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.ControladoraLogica;

@WebServlet(name = "SvLogin", urlPatterns = {"/SvLogin"})
public class SvLogin extends HttpServlet {
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
        String usuario = request.getParameter("nombreUsuario");
        String contrasenia = request.getParameter("contraseniaUsuario");
        boolean autorizado = control.verificarUsuario(usuario, contrasenia);
        if(autorizado == true){
            HttpSession misession = request.getSession(true);
            misession.setAttribute("nombreUsuario", usuario);
            misession.setAttribute("contraseniaUsuario", contrasenia);
            response.sendRedirect("panelAdministracion.jsp");
        } else {
            response.sendRedirect("login.jsp");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
