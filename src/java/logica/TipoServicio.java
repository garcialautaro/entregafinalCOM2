package logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipoServicio implements Serializable {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codTipoServicio;
    @Basic
    private String nombreTipoServicio;
    
    //constructores

    public TipoServicio() {
    }

    public TipoServicio(String nombreTipoServicio) {
        this.nombreTipoServicio = nombreTipoServicio;
    }
    
    //getter y setter

    public int getCodTipoServicio() {
        return codTipoServicio;
    }

    public void setCodTipoServicio(int codTipoServicio) {
        this.codTipoServicio = codTipoServicio;
    }

    public String getNombreTipoServicio() {
        return nombreTipoServicio;
    }

    public void setNombreTipoServicio(String nombreTipoServicio) {
        this.nombreTipoServicio = nombreTipoServicio;
    }
    
}
