package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.ControladoraLogica;

@WebServlet(name = "SvAltaCliente", urlPatterns = {"/SvAltaCliente"})
public class SvAltaCliente extends HttpServlet {

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

        String nombreCliente = request.getParameter("nombreCliente");
        String apellidoCliente = request.getParameter("apellidoCliente");
        String nacionalidadCliente = request.getParameter("nacionalidadCliente");
        String celularCliente = request.getParameter("celularCliente");
        String direccionCliente = request.getParameter("direccionCliente");
        String dniCliente = request.getParameter("dniCliente");
        String emailCliente = request.getParameter("emailCliente");
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaNacCliente = null;
        try {
            fechaNacCliente = formato.parse(request.getParameter("fechaNacCliente"));
        } catch (ParseException ex) {
            Logger.getLogger(SvAltaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        control.altaCliente(apellidoCliente, celularCliente, direccionCliente,
                dniCliente, emailCliente, fechaNacCliente,
                nacionalidadCliente, nombreCliente);
        response.sendRedirect("altaCliente.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
