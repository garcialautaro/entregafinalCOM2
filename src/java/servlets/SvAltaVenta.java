package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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

@WebServlet(name = "SvAltaVenta", urlPatterns = {"/SvAltaVenta"})
public class SvAltaVenta extends HttpServlet {
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
     
        HttpSession misession = request.getSession();
        List<Servicio> listaServicios = (List)misession.getAttribute("listaServicios");
        List<Paquete> listaPaquetes = (List)misession.getAttribute("listaPaquetes");
        List<Vendedor> listaVendedores =  (List)misession.getAttribute("listaVendedores");
        List<Cliente> listaClientes = (List) misession.getAttribute("listaClientes");
        List<MedioPago> listaMedioPagos = (List)misession.getAttribute("listaMedioPagos");
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaVenta = null;
        try {
            fechaVenta = formato.parse(request.getParameter("fechaVenta"));
        } catch (ParseException ex) {
            Logger.getLogger(SvAltaVendedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Vendedor vendedor = null ;
        for(Vendedor ve: listaVendedores) {
            if(ve.getIdVendedor()==Integer.parseInt(request.getParameter("codigoVendedor"))) {
                vendedor = ve;
            }
        }
        Cliente cliente = null;
        for(Cliente cli: listaClientes) {
            if(cli.getIdCliente()==Integer.parseInt(request.getParameter("codigoCliente"))) {
                cliente = cli;
            }
        }
        MedioPago medioPago = null;
        for(MedioPago mp: listaMedioPagos) {
            if(mp.getCodMedioPago()==Integer.parseInt(request.getParameter("codigoMP"))) {
                medioPago = mp;
            }
        }
        Servicio servicio = null;
        for(Servicio serv: listaServicios) {
            if(serv.getCodigoServicio()==Integer.parseInt(request.getParameter("codigoServicio"))) {
                servicio = serv;
            }
        }
        Paquete paquete = null;
        for(Paquete paq: listaPaquetes) {
            if(paq.getCodigoPaquete()==Integer.parseInt(request.getParameter("codigoPaquete"))) {
                paquete = paq;
            }
        }
        control.altaVenta(fechaVenta, vendedor, cliente, medioPago, servicio, paquete);
        response.sendRedirect("altaVenta.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
