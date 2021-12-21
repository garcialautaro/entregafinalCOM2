package logica;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.ControladoraPersistencia;

public class ControladoraLogica {

    public ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    //CLIENTE --------------------------------------------------------------------------------------
        //ALTA CLIENTE ---------------------------------------------------------
    public void altaCliente(String apellidoPersona,
            String celularPersona, String direccionPersona, String dniPersona,
            String emailPersona, Date fechaNacPersona, String nacionalidadPersona,
            String nombrePersona) {
        Cliente cli = new Cliente(nombrePersona, apellidoPersona,
                nacionalidadPersona, celularPersona, direccionPersona,
                dniPersona, emailPersona, fechaNacPersona);
        try {
            controlPersis.altaCliente(cli);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        //BORRAR CLIENTE -------------------------------------------------------
    public void borrarCliente(Integer id) {
        controlPersis.borrarCliente(id);
    }    
        //TRAER CLIENTES -------------------------------------------------------
    public List<Cliente> traerClientes() {
        return controlPersis.traerClientes();
    }
        //BUSCAR CLIENTE -------------------------------------------------------
    public Cliente buscarCliente(Integer id) {
        return controlPersis.buscarCliente(id);
    }
        //MODIFICAR CLIENTE ----------------------------------------------------
    public void modificarCliente(Integer idCliente, String nombreCliente, String apellidoCliente, String nacionalidadCliente, String celularCliente, String direccionCliente, String dniCliente, String emailCliente, Date fechaNacCliente) {
        Cliente cli = buscarCliente(idCliente);
        cli.setNombreCliente(nombreCliente);
        cli.setApellidoCliente(apellidoCliente);
        cli.setNacionalidadCliente(nacionalidadCliente);
        cli.setCelularCliente(celularCliente);
        cli.setDireccionCliente(direccionCliente);
        cli.setDniCliente(dniCliente);
        cli.setEmailCliente(emailCliente);
        cli.setFechaNacCliente(fechaNacCliente);
        controlPersis.modificarCliente(cli);
    }
    
    
    //VENDEDOR -------------------------------------------------------------------------------------
        //ALTA VENDEDOR --------------------------------------------------------
    public void altaVendedor(String nombreVendedor, String apellidoVendedor, String nacionalidadVendedor,
            String celularVendedor, String direccionVendedor, String dniVendedor, String emailVendedor,
            Date fechaNacVendedor, String cargoVendedor, Double sueldoVendedor, String nombreUsuario,
            String contraseniaUsuario) {
        Usuario usu = new Usuario();
        Vendedor ve = new Vendedor();
        //asigno valores a usuario
        usu.setNombreUsuario(nombreUsuario);
        usu.setContraseniaUsuario(contraseniaUsuario);
        //asigno valores a vendedor
        ve.setNombreVendedor(nombreVendedor);
        ve.setApellidoVendedor(apellidoVendedor);
        ve.setNacionalidadVendedor(nacionalidadVendedor);
        ve.setCelularVendedor(celularVendedor);
        ve.setDireccionVendedor(direccionVendedor);
        ve.setDniVendedor(dniVendedor);
        ve.setEmailVendedor(emailVendedor);
        ve.setFechaNacVendedor(fechaNacVendedor);
        ve.setCargoVendedor(cargoVendedor);
        ve.setSueldoVendedor(sueldoVendedor);
        //asigno usuario a vendedor
        ve.setUsuario(usu);
        //ALTAS
        controlPersis.altaUsuario(usu);
        controlPersis.altaVendedor(ve);
    }
        //BORRAR VENDEDOR ------------------------------------------------------
    public void borrarVendedor(Integer id) {
        controlPersis.borrarVendedor(id);
    }
        //LISTA VENDEDOR -------------------------------------------------------
    public List<Vendedor> traerVendedores() {
        return controlPersis.traerVendedores();
    }
        //BUSCAR VENDEDOR ------------------------------------------------------
    public Vendedor buscarVendedor(Integer id) {
        return controlPersis.buscarVendedor(id) ;
    }
        //MODIFICAR VENDEDOR ---------------------------------------------------
    public void modificarVendedor(Integer idVendedor, String nombreVendedor, String apellidoVendedor, String nacionalidadVendedor, 
            String celularVendedor, String direccionVendedor, String dniVendedor, String emailVendedor, 
            Date fechaNacVendedor, String cargoVendedor, Double sueldoVendedor) {
        Vendedor ve = buscarVendedor(idVendedor);
        ve.setIdVendedor(idVendedor);
        ve.setNombreVendedor(nombreVendedor);
        ve.setApellidoVendedor(apellidoVendedor);
        ve.setNacionalidadVendedor(nacionalidadVendedor);
        ve.setCelularVendedor(celularVendedor);
        ve.setDireccionVendedor(direccionVendedor);
        ve.setDniVendedor(dniVendedor);
        ve.setEmailVendedor(emailVendedor);
        ve.setFechaNacVendedor(fechaNacVendedor);
        ve.setCargoVendedor(cargoVendedor);
        ve.setSueldoVendedor(sueldoVendedor);
        controlPersis.modificarVendedor(ve);
    }
    
    
    //USUARIOS -----------------------------------------------------------------------------------
        //LISTA USUARIOS -------------------------------------------------------
    public List<Usuario> traerUsuarios() {
        return controlPersis.traerUsuarios();
    }
        //VERIFICAR USUARIO ----------------------------------------------------
    public boolean verificarUsuario(String usuario, String contrasenia) {
        List<Usuario> listaUsuarios = controlPersis.traerUsuarios();
        if (listaUsuarios != null) {
            for (Usuario usu : listaUsuarios) {
                if (usu.getNombreUsuario().equals(usuario) && usu.getContraseniaUsuario().equals(contrasenia)) {
                    return true;
                }
            }
        }
        return false;
    }
        //ELIMINAR USUARIO -----------------------------------------------------
    public void borrarUsuario(Integer id) {
        controlPersis.borrarUsuario(id);
    }
    
    
    //TIPO SERVICIO -------------------------------------------------------------------------------
        //ALTA TIPO DE SERVICIO ------------------------------------------------
    public void altaTipoServicio(String nombreTipoServicio) {
        TipoServicio tipoServ = new TipoServicio();
        tipoServ.setNombreTipoServicio(nombreTipoServicio);
        controlPersis.altaTipoServicio(tipoServ);
    }
        //BAJA TIPO SERVICIO ---------------------------------------------------
    public void borrarTipoServicio (Integer id) {
        controlPersis.borrarTipoServicio(id);
    }
        //LISTA TIPO SERVICIOS -------------------------------------------------
    public List<TipoServicio> traerTipoServicios() {
        return controlPersis.traerTipoServicios();
    }
    
    
    //SERVICIO ------------------------------------------------------------------------------------
        //ALTA SERVICIO --------------------------------------------------------
    public void altaServicio(String nombreServicio, Double costoServicio, String descripcionServicio, String destinoServicio, Date fechaServicio, TipoServicio objetoTipoServicio) {
        Servicio serv = new Servicio();
        serv.setNombreServicio(nombreServicio);
        serv.setCostoServicio(costoServicio);
        serv.setDescripcionServicio(descripcionServicio);
        serv.setDestinoServicio(destinoServicio);
        serv.setFechaServicio(fechaServicio);
        serv.setTipoServicio(objetoTipoServicio);
        controlPersis.altaServicio(serv);
    }
        //LISTA DE SERVICIOS ---------------------------------------------------
    public List<Servicio> traerServicios() {
        return controlPersis.traerServicios();
    }
        //BORRAR SERVICIO ------------------------------------------------------
    public void borrarServicio(Integer id) {
        controlPersis.borrarServicio(id);
    }
    
    
    
    //PAQUETES -----------------------------------------------------------------------------------
        //ALTA PAQUETE ---------------------------------------------------------
    public void altaPaquete(Double costoPaquete, List<Servicio> serviciosIncluidos) {
        Paquete paq = new Paquete();
        paq.setCostoPaquete(costoPaquete);
        paq.setListaServiciosIncluidos(serviciosIncluidos);
        controlPersis.altaPaquete(paq);
    }
        //LISTA PAQUETES -------------------------------------------------------
    public List<Paquete> traerPaquetes() {
        return controlPersis.traerPaquetes();
    }
        //ELIMINAR PAQUETE -----------------------------------------------------
    public void borrarPaquete(Integer id) {
        controlPersis.borrarPaquete(id);
    }
    
    
    
    //MEDIOS DE PAGO -----------------------------------------------------------------------------
        //ALTA MEDIO DE PAGO ---------------------------------------------------
    public void altaMedioPago(String nombreMP, Double comisionMP) {
        MedioPago mp = new MedioPago();
        mp.setNombreMP(nombreMP);
        mp.setComisionMP(comisionMP);
        controlPersis.altaMedioPago(mp);
    }
        //LISTA MEDIOS DE PAGO -------------------------------------------------
    public List<MedioPago> traerMedioPagos() {
        return controlPersis.traerMedioPagos();
    }
        //ELIMINAR MEDIO PAGO --------------------------------------------------
    public void borrarMedioPago(Integer id) {
        controlPersis.borrarMedioPago(id);
    }
    
    
    
    //VENTAS -------------------------------------------------------------------------------------
        //ALTA VENTA -----------------------------------------------------------
    public void altaVenta(Date fechaVenta, Vendedor vendedor, Cliente cliente, MedioPago medioPago, Servicio servicio, Paquete paquete) {
        Venta ve = new Venta();
        ve.setFechaVenta(fechaVenta);
        ve.setVendedor(vendedor);
        ve.setCliente(cliente);
        ve.setMedioPago(medioPago);
        ve.setServicio(servicio);
        ve.setPaquete(paquete);
        controlPersis.altaVenta(ve);
    }
        //LISTA DE VENTAS ------------------------------------------------------
    public List<Venta> traerVentas() {
        return controlPersis.traerVentas();
    }
        //ELIMINAR VENTA -------------------------------------------------------
    public void borrarVenta(Integer id) {
        controlPersis.borrarVenta(id);
    }










}
