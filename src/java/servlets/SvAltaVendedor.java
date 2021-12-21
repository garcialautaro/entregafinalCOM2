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

@WebServlet(name = "SvAltaVendedor", urlPatterns = {"/SvAltaVendedor"})
public class SvAltaVendedor extends HttpServlet {

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

        String nombreVendedor = request.getParameter("nombreVendedor");
        String apellidoVendedor = request.getParameter("apellidoVendedor");
        String nacionalidadVendedor = request.getParameter("nacionalidadVendedor");
        String celularVendedor = request.getParameter("celularVendedor");
        String direccionVendedor = request.getParameter("direccionVendedor");
        String dniVendedor = request.getParameter("dniVendedor");
        String emailVendedor = request.getParameter("emailVendedor");
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        Date fechaNacVendedor = null;
        try {
            fechaNacVendedor = formato.parse(request.getParameter("fechaNacVendedor"));
        } catch (ParseException ex) {
            Logger.getLogger(SvAltaVendedor.class.getName()).log(Level.SEVERE, null, ex);
        }

        String cargoVendedor = request.getParameter("cargoVendedor");
        Double sueldoVendedor = Double.parseDouble(request.getParameter("sueldoVendedor"));
        String nombreUsuario = request.getParameter("nombreUsuario");
        String contraseniaUsuario = request.getParameter("contraseniaUsuario");

        control.altaVendedor(nombreVendedor, apellidoVendedor, nacionalidadVendedor,
                celularVendedor, direccionVendedor, dniVendedor, emailVendedor, fechaNacVendedor,
                cargoVendedor, sueldoVendedor, nombreUsuario, contraseniaUsuario);
        response.sendRedirect("altaVendedor.jsp");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
