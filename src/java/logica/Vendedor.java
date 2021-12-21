package logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Vendedor implements Serializable{
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idVendedor;
    @Basic
    private String nombreVendedor;
    private String apellidoVendedor;
    private String nacionalidadVendedor;
    private String celularVendedor;
    private String direccionVendedor;
    private String dniVendedor;
    private String emailVendedor;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacVendedor;
    @Basic
    private String cargoVendedor;
    private Double sueldoVendedor;
    @OneToOne
    private Usuario usuario;
    
    //constructores

    public Vendedor() {
    }

    public Vendedor(Integer idVendedor, String nombreVendedor, String apellidoVendedor, String nacionalidadVendedor, String celularVendedor, String direccionVendedor, String dniVendedor, String emailVendedor, Date fechaNacVendedor, String cargoVendedor, Double sueldoVendedor, Usuario usuario) {
        this.idVendedor = idVendedor;
        this.nombreVendedor = nombreVendedor;
        this.apellidoVendedor = apellidoVendedor;
        this.nacionalidadVendedor = nacionalidadVendedor;
        this.celularVendedor = celularVendedor;
        this.direccionVendedor = direccionVendedor;
        this.dniVendedor = dniVendedor;
        this.emailVendedor = emailVendedor;
        this.fechaNacVendedor = fechaNacVendedor;
        this.cargoVendedor = cargoVendedor;
        this.sueldoVendedor = sueldoVendedor;
        this.usuario = usuario;
    }

    //getters y setters

    public Integer getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Integer idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getNombreVendedor() {
        return nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    public String getApellidoVendedor() {
        return apellidoVendedor;
    }

    public void setApellidoVendedor(String apellidoVendedor) {
        this.apellidoVendedor = apellidoVendedor;
    }

    public String getNacionalidadVendedor() {
        return nacionalidadVendedor;
    }

    public void setNacionalidadVendedor(String nacionalidadVendedor) {
        this.nacionalidadVendedor = nacionalidadVendedor;
    }

    public String getCelularVendedor() {
        return celularVendedor;
    }

    public void setCelularVendedor(String celularVendedor) {
        this.celularVendedor = celularVendedor;
    }

    public String getDireccionVendedor() {
        return direccionVendedor;
    }

    public void setDireccionVendedor(String direccionVendedor) {
        this.direccionVendedor = direccionVendedor;
    }

    public String getDniVendedor() {
        return dniVendedor;
    }

    public void setDniVendedor(String dniVendedor) {
        this.dniVendedor = dniVendedor;
    }

    public String getEmailVendedor() {
        return emailVendedor;
    }

    public void setEmailVendedor(String emailVendedor) {
        this.emailVendedor = emailVendedor;
    }

    public Date getFechaNacVendedor() {
        return fechaNacVendedor;
    }

    public void setFechaNacVendedor(Date fechaNacVendedor) {
        this.fechaNacVendedor = fechaNacVendedor;
    }

    public String getCargoVendedor() {
        return cargoVendedor;
    }

    public void setCargoVendedor(String cargoVendedor) {
        this.cargoVendedor = cargoVendedor;
    }

    public Double getSueldoVendedor() {
        return sueldoVendedor;
    }

    public void setSueldoVendedor(Double sueldoVendedor) {
        this.sueldoVendedor = sueldoVendedor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
