package logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Paquete implements Serializable {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigoPaquete;
    @Basic
    private Double costoPaquete;
    @ManyToMany
    private List<Servicio> listaServiciosIncluidos;
    
    //constructores

    public Paquete() {
    }
    
    public Paquete(Double costoPaquete, List<Servicio> listaServiciosIncluidos) {
        this.costoPaquete = costoPaquete;
        this.listaServiciosIncluidos = listaServiciosIncluidos;
    }
    
    //getters y setters

    public Integer getCodigoPaquete() {
        return codigoPaquete;
    }

    public void setCodigoPaquete(Integer codigoPaquete) {
        this.codigoPaquete = codigoPaquete;
    }

    public Double getCostoPaquete() {
        return costoPaquete;
    }

    public void setCostoPaquete(Double costoPaquete) {
        this.costoPaquete = costoPaquete;
    }

    public List<Servicio> getListaServiciosIncluidos() {
        return listaServiciosIncluidos;
    }

    public void setListaServiciosIncluidos(List<Servicio> listaServiciosIncluidos) {
        this.listaServiciosIncluidos = listaServiciosIncluidos;
    }
    
}
