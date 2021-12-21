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
import logica.ControladoraLogica;
import logica.TipoServicio;

@WebServlet(name = "SvAltaServicio", urlPatterns = {"/SvAltaServicio"})
public class SvAltaServicio extends HttpServlet {
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
        List<TipoServicio> listaTipoServicios = (List) misession.getAttribute("listaTipoServicios");
        Integer codTipoServicio = Integer.parseInt(request.getParameter("codTipoServicio"));
        String nombreServicio = request.getParameter("nombreServicio");
        Double costoServicio = Double.parseDouble(request.getParameter("costoServicio"));
        String descripcionServicio = request.getParameter("descripcionServicio");
        String destinoServicio = request.getParameter("destinoServicio");
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaServicio = null;
        try {
            fechaServicio = formato.parse(request.getParameter("fechaServicio"));
        } catch (ParseException ex) {
            Logger.getLogger(SvAltaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        TipoServicio objetoTipoServicio = null;
        for(TipoServicio tipoServ:listaTipoServicios) {
            if(tipoServ.getCodTipoServicio() == codTipoServicio) {
                objetoTipoServicio = tipoServ;
            }
        }
        control.altaServicio(nombreServicio, costoServicio, descripcionServicio,
                destinoServicio, fechaServicio, objetoTipoServicio);
        response.sendRedirect("altaServicio.jsp"); 
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
