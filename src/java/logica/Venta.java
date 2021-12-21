package logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Venta implements Serializable {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer numeroVenta;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVenta;
    @ManyToOne
    private Vendedor vendedor;
    private Cliente cliente;
    private MedioPago medioPago;
    private Servicio servicio;
    private Paquete paquete;
    //constructor

    public Venta() {
    }

    public Venta(Date fechaVenta, Vendedor vendedor, Cliente cliente, MedioPago medioPago, Servicio servicio, Paquete paquete) {
        this.fechaVenta = fechaVenta;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.medioPago = medioPago;
        this.servicio = servicio;
        this.paquete = paquete;
    }
    
    //getter y setter

    public Integer getNumeroVenta() {
        return numeroVenta;
    }

    public void setNumeroVenta(Integer numeroVenta) {
        this.numeroVenta = numeroVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public MedioPago getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(MedioPago medioPago) {
        this.medioPago = medioPago;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }
    
    
    
    
}
