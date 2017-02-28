/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author snrivera
 */
@Entity
@Table(name = "autenticacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Autenticacion.findAll", query = "SELECT a FROM Autenticacion a")
    , @NamedQuery(name = "Autenticacion.findByIdUsuario", query = "SELECT a FROM Autenticacion a WHERE a.idUsuario = :idUsuario")
    , @NamedQuery(name = "Autenticacion.findByPass", query = "SELECT a FROM Autenticacion a WHERE a.pass = :pass")
    , @NamedQuery(name = "Autenticacion.findByCorreo", query = "SELECT a FROM Autenticacion a WHERE a.correo = :correo")})
public class Autenticacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_USUARIO")
    private Integer idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "PASS")
    private String pass;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "CORREO")
    private String correo;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuario usuario;

    public Autenticacion() {
    }

    public Autenticacion(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Autenticacion(Integer idUsuario, String pass, String correo) {
        this.idUsuario = idUsuario;
        this.pass = pass;
        this.correo = correo;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Autenticacion)) {
            return false;
        }
        Autenticacion other = (Autenticacion) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Autenticacion[ idUsuario=" + idUsuario + " ]";
    }
    
}
