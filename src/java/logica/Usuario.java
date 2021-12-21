package logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Usuario implements Serializable {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idUsuario;
    @Basic
    private String nombreUsuario;
    private String contraseniaUsuario;

    
    //constructores

    public Usuario() {
    }

    public Usuario(String nombreUsuario, String contraseniaUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.contraseniaUsuario = contraseniaUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    //getters y setters
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseniaUsuario() {
        return contraseniaUsuario;
    }

    public void setContraseniaUsuario(String contraseniaUsuario) {
        this.contraseniaUsuario = contraseniaUsuario;
    }

    
    
}
