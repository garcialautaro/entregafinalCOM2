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
import logica.Cliente;
import logica.ControladoraLogica;
import logica.MedioPago;
import logica.Paquete;
import logica.Servicio;
import logica.Vendedor;
import logica.Venta;

@WebServlet(name = "SvAdmVentas", urlPatterns = {"/SvAdmVentas"})
public class SvAdmVentas extends HttpServlet {
    ControladoraLogica control = new ControladoraLogica();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Venta> listaVentas = control.traerVentas();
        List<Servicio> listaServicios = control.traerServicios();
        List<Paquete> listaPaquetes = control.traerPaquetes();
        List<Vendedor> listaVendedores = control.traerVendedores();
        List<Cliente> listaClientes = control.traerClientes();
        List<MedioPago> listaMedioPagos = control.traerMedioPagos();
        HttpSession misession =request.getSession();
        misession.setAttribute("listaVentas", listaVentas);
        misession.setAttribute("listaServicios", listaServicios);
        misession.setAttribute("listaPaquetes", listaPaquetes);
        misession.setAttribute("listaVendedores", listaVendedores);
        misession.setAttribute("listaClientes", listaClientes);
        misession.setAttribute("listaMedioPagos", listaMedioPagos);
        /////////////////////////
        response.sendRedirect("admVentas.jsp");
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
