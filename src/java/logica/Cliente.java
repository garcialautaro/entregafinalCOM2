package logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Cliente implements Serializable {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idCliente;
    @Basic
    private String nombreCliente;
    private String apellidoCliente;
    private String nacionalidadCliente;
    private String celularCliente;
    private String direccionCliente;
    private String dniCliente;
    private String emailCliente;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacCliente;
    //Constructores
    public Cliente() {
    }
    public Cliente(String nombreCliente, String apellidoCliente, String nacionalidadCliente, String celularCliente, String direccionCliente, String dniCliente, String emailCliente, Date fechaNacCliente) {
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.nacionalidadCliente = nacionalidadCliente;
        this.celularCliente = celularCliente;
        this.direccionCliente = direccionCliente;
        this.dniCliente = dniCliente;
        this.emailCliente = emailCliente;
        this.fechaNacCliente = fechaNacCliente;
    }

    //getters y setters

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getNacionalidadCliente() {
        return nacionalidadCliente;
    }

    public void setNacionalidadCliente(String nacionalidadCliente) {
        this.nacionalidadCliente = nacionalidadCliente;
    }

    public String getCelularCliente() {
        return celularCliente;
    }

    public void setCelularCliente(String celularCliente) {
        this.celularCliente = celularCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public Date getFechaNacCliente() {
        return fechaNacCliente;
    }

    public void setFechaNacCliente(Date fechaNacCliente) {
        this.fechaNacCliente = fechaNacCliente;
    }
    
    
}