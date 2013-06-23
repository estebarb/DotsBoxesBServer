/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Esteban
 */
@Entity
@Table(name = "Usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findById", query = "SELECT u FROM Usuarios u WHERE u.id = :id"),
    @NamedQuery(name = "Usuarios.findByEmail", query = "SELECT u FROM Usuarios u WHERE u.email = :email"),
    @NamedQuery(name = "Usuarios.findByNombre", query = "SELECT u FROM Usuarios u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Usuarios.findByPasswordhash", query = "SELECT u FROM Usuarios u WHERE u.passwordhash = :passwordhash"),
    @NamedQuery(name = "Usuarios.findByRanking", query = "SELECT u FROM Usuarios u WHERE u.ranking = :ranking")})
public class Usuarios implements Serializable {
    @Column(name = "password")
    private String password;
    @Column(name = "salt")
    private String salt;
    @Column(name = "lastlogin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastlogin;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "email")
    private String email;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "passwordhash")
    private String passwordhash;
    @Column(name = "ranking")
    private Integer ranking;
    @OneToMany(mappedBy = "jugador")
    private Collection<Pendientes> pendientesCollection;
    @OneToMany(mappedBy = "usuario")
    private Collection<Jugadores> jugadoresCollection;
    @OneToMany(mappedBy = "jugador")
    private Collection<MiembrosEquipo> miembrosEquipoCollection;
    @OneToMany(mappedBy = "administrador")
    private Collection<Torneos> torneosCollection;

    public Usuarios() {
    }

    public Usuarios(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPasswordhash() {
        return passwordhash;
    }

    public void setPasswordhash(String passwordhash) {
        this.passwordhash = passwordhash;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    @XmlTransient
    public Collection<Pendientes> getPendientesCollection() {
        return pendientesCollection;
    }

    public void setPendientesCollection(Collection<Pendientes> pendientesCollection) {
        this.pendientesCollection = pendientesCollection;
    }

    @XmlTransient
    public Collection<Jugadores> getJugadoresCollection() {
        return jugadoresCollection;
    }

    public void setJugadoresCollection(Collection<Jugadores> jugadoresCollection) {
        this.jugadoresCollection = jugadoresCollection;
    }

    @XmlTransient
    public Collection<MiembrosEquipo> getMiembrosEquipoCollection() {
        return miembrosEquipoCollection;
    }

    public void setMiembrosEquipoCollection(Collection<MiembrosEquipo> miembrosEquipoCollection) {
        this.miembrosEquipoCollection = miembrosEquipoCollection;
    }

    @XmlTransient
    public Collection<Torneos> getTorneosCollection() {
        return torneosCollection;
    }

    public void setTorneosCollection(Collection<Torneos> torneosCollection) {
        this.torneosCollection = torneosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Usuarios[ id=" + id + " ]";
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Date getLastlogin() {
        return lastlogin;
    }

    public void setLastlogin(Date lastlogin) {
        this.lastlogin = lastlogin;
    }
    
}
