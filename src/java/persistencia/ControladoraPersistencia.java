package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Cliente;
import logica.MedioPago;
import logica.Paquete;
import logica.Servicio;
import logica.TipoServicio;
import logica.Usuario;
import logica.Vendedor;
import logica.Venta;
import persistencia.exceptions.NonexistentEntityException;

public class ControladoraPersistencia {
    ClienteJpaController clienteJPA = new ClienteJpaController();
    MedioPagoJpaController medioPagoJPA = new MedioPagoJpaController();
    PaqueteJpaController paqueteJPA = new PaqueteJpaController();
    ServicioJpaController servicioJPA = new ServicioJpaController();
    TipoServicioJpaController tipoServicioJPA = new TipoServicioJpaController();
    UsuarioJpaController usuarioJPA = new UsuarioJpaController();
    VendedorJpaController vendedorJPA = new VendedorJpaController();
    VentaJpaController ventaJPA = new VentaJpaController();

    //CLIENTE --------------------------------------------------------------------------------------
        //ALTA CLIENTE ---------------------------------------------------------
    public void altaCliente(Cliente cli) {
        try {
            clienteJPA.create(cli);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        //BAJA CLIENTE ---------------------------------------------------------
    public void borrarCliente(Integer id) {
        try {
            clienteJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
        //TRAER CLIENTES -------------------------------------------------------
    public List<Cliente> traerClientes() {
        return clienteJPA.findClienteEntities();
    }
    
        //BUSCAR CLIENTE -------------------------------------------------------
    public Cliente buscarCliente(Integer id) {
        return clienteJPA.findCliente(id);
    }
        //MODIFICAR CLIENTE ----------------------------------------------------
    public void modificarCliente(Cliente cli) {
        try {
            clienteJPA.edit(cli);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //VENDEDOR -------------------------------------------------------------------------------------
        //ALTA VENDEDOR --------------------------------------------------------
    public void altaVendedor(Vendedor ve) { 
        try {
            vendedorJPA.create(ve);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        //LISTA VENDEDOR -------------------------------------------------------
    public List<Vendedor> traerVendedores (){
        return vendedorJPA.findVendedorEntities();
    }
        //BAJA VENDEDOR --------------------------------------------------------
    public void borrarVendedor(Integer id) {
        try {
            vendedorJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
        //BUSCAR VENDEDOR ------------------------------------------------------
    public Vendedor buscarVendedor(Integer id) {
        return vendedorJPA.findVendedor(id);
    }
        //MODIFICAR VENDEDOR ---------------------------------------------------    
    public void modificarVendedor(Vendedor ve) {
        try {
            vendedorJPA.edit(ve);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    //USUARIO --------------------------------------------------------------------------------------
        //ALTA USUARIO ---------------------------------------------------------
    public void altaUsuario(Usuario usu) {
        try {
            usuarioJPA.create(usu);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        //LISTA USUARIO --------------------------------------------------------
    public List<Usuario> traerUsuarios() {
        return usuarioJPA.findUsuarioEntities();
    }
        //BAJA USUARIO ---------------------------------------------------------
    public void borrarUsuario(Integer id) {
        try {
            usuarioJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    //TIPO SERVICIO --------------------------------------------------------------------------------
        //ALTA TIPO SERVICIO ---------------------------------------------------
    public void altaTipoServicio(TipoServicio tipoServ){
        try {
            tipoServicioJPA.create(tipoServ);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        //BAJA TIPO SERVICIO ---------------------------------------------------
    public void borrarTipoServicio(Integer id) { 
        try {
            tipoServicioJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        // LISTA TIPO SERVICIOS ------------------------------------------------
    public List<TipoServicio> traerTipoServicios() {
        return tipoServicioJPA.findTipoServicioEntities();
    }

    
    //SERVICIO -------------------------------------------------------------------------------------
        //ALTA SERVICIO --------------------------------------------------------
    public void altaServicio(Servicio serv) {
        try {
            servicioJPA.create(serv);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        //LISTA SERVICIOS ------------------------------------------------------
    public List<Servicio> traerServicios() {
        return servicioJPA.findServicioEntities();
    }
        //BORRAR SERVICIO ------------------------------------------------------
    public void borrarServicio(Integer id) {
        try {
            servicioJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    //PAQUETE -------------------------------------------------------------------------------------
        //ALTA PAQUETE ---------------------------------------------------------
    public void altaPaquete(Paquete paq) {
        try {
            paqueteJPA.create(paq);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        // LISTA PAQUETES ------------------------------------------------------
    public List<Paquete> traerPaquetes() {
        return paqueteJPA.findPaqueteEntities();
    }
        //BORRAR PAQUETE -------------------------------------------------------
    public void borrarPaquete(Integer id) {
        try {
            paqueteJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    //MEDIOS DE PAGO -------------------------------------------------------------------------------
        //ALTA MEDIO DE PAGO ---------------------------------------------------
    public void altaMedioPago(MedioPago mp) {
        try {
            medioPagoJPA.create(mp);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        //LISTA MEDIOS DE PAGO -------------------------------------------------
    public List<MedioPago> traerMedioPagos() {
        return medioPagoJPA.findMedioPagoEntities();
    }
        //BORRAR MEDIO PAGO ----------------------------------------------------
    public void borrarMedioPago(Integer id) {
        try {
            medioPagoJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    //VENTA ---------------------------------------------------------------------------------------
        //ALTA VENTA -----------------------------------------------------------
    public void altaVenta(Venta ve) {
        try {
            ventaJPA.create(ve);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        //LISTA VENTAS ---------------------------------------------------------
    public List<Venta> traerVentas() {
        return ventaJPA.findVentaEntities();
    }
        //BORRAR VENTA ---------------------------------------------------------
    public void borrarVenta(Integer id) {
        try {
            ventaJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }













}
