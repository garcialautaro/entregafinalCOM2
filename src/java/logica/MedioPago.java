package logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MedioPago implements Serializable {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codMedioPago;
    @Basic
    private Double comisionMP;
    private String nombreMP;
    
    //constructores

    public MedioPago() {
    }

    public MedioPago(Double comisionMP, String nombreMP) {
        this.comisionMP = comisionMP;
        this.nombreMP = nombreMP;
    }
    
    //getters y setters

    public Integer getCodMedioPago() {
        return codMedioPago;
    }

    public void setCodMedioPago(Integer codMedioPago) {
        this.codMedioPago = codMedioPago;
    }

    public Double getComisionMP() {
        return comisionMP;
    }

    public void setComisionMP(Double comisionMP) {
        this.comisionMP = comisionMP;
    }

    public String getNombreMP() {
        return nombreMP;
    }

    public void setNombreMP(String nombreMP) {
        this.nombreMP = nombreMP;
    }
    
}
