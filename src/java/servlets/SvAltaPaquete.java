package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.ControladoraLogica;
import logica.Servicio;

@WebServlet(name = "SvAltaPaquete", urlPatterns = {"/SvAltaPaquete"})
public class SvAltaPaquete extends HttpServlet {
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
        //String value = "form";
        List<Servicio> listaServicios = (List) misession.getAttribute("listaServicios");
        List<Servicio> serviciosIncluidos = new ArrayList();
        for (Servicio serv:listaServicios) {
            if(serv.getCodigoServicio()==Integer.parseInt(request.getParameter("codigoServicio1"))) {
                serviciosIncluidos.add(serv);
            }
        }
        for (Servicio serv:listaServicios) {
            if(serv.getCodigoServicio()==Integer.parseInt(request.getParameter("codigoServicio2"))) {
                serviciosIncluidos.add(serv);
            }
        }
        for (Servicio serv:listaServicios) {
            if(serv.getCodigoServicio()==Integer.parseInt(request.getParameter("codigoServicio3"))) {
                serviciosIncluidos.add(serv);
            }
        }
        for (Servicio serv:listaServicios) {
            if(serv.getCodigoServicio()==Integer.parseInt(request.getParameter("codigoServicio4"))) {
                serviciosIncluidos.add(serv);
            }
        }
        for (Servicio serv:listaServicios) {
            if(serv.getCodigoServicio()==Integer.parseInt(request.getParameter("codigoServicio5"))) {
                serviciosIncluidos.add(serv);
            }
        }
        Double costoPaquete = Double.parseDouble(request.getParameter("costoPaquete"));

        control.altaPaquete(costoPaquete,serviciosIncluidos);
        response.sendRedirect("altaPaquete.jsp"); 
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
