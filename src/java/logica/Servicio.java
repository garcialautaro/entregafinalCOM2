package logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Servicio implements Serializable {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigoServicio;
    @Basic
    private String nombreServicio;
    private Double costoServicio;
    private String descripcionServicio;
    private String destinoServicio;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaServicio;
    @ManyToOne
    private TipoServicio tipoServicio;
    @ManyToMany
    private List<Paquete> listaPaquetes;
    
    //constructores

    public Servicio() {
    }

    public Servicio(String nombreServicio, Double costoServicio, String descripcionServicio, String destinoServicio, Date fechaServicio, TipoServicio tipoServicio) {
        this.nombreServicio = nombreServicio;
        this.costoServicio = costoServicio;
        this.descripcionServicio = descripcionServicio;
        this.destinoServicio = destinoServicio;
        this.fechaServicio = fechaServicio;
        this.tipoServicio = tipoServicio;
    }
    
    //getter y setter

    public Integer getCodigoServicio() {
        return codigoServicio;
    }

    public void setCodigoServicio(Integer codigoServicio) {
        this.codigoServicio = codigoServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public Double getCostoServicio() {
        return costoServicio;
    }

    public void setCostoServicio(Double costoServicio) {
        this.costoServicio = costoServicio;
    }

    public String getDescripcionServicio() {
        return descripcionServicio;
    }

    public void setDescripcionServicio(String descripcionServicio) {
        this.descripcionServicio = descripcionServicio;
    }

    public String getDestinoServicio() {
        return destinoServicio;
    }

    public void setDestinoServicio(String destinoServicio) {
        this.destinoServicio = destinoServicio;
    }

    public Date getFechaServicio() {
        return fechaServicio;
    }

    public void setFechaServicio(Date fechaServicio) {
        this.fechaServicio = fechaServicio;
    }

    public TipoServicio getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(TipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public List<Paquete> getListaPaquetes() {
        return listaPaquetes;
    }

    public void setListaPaquetes(List<Paquete> listaPaquetes) {
        this.listaPaquetes = listaPaquetes;
    }
    
}
