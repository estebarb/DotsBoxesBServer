/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Esteban
 */
@Entity
@Table(name = "JugadoresPC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JugadoresPC.findAll", query = "SELECT j FROM JugadoresPC j"),
    @NamedQuery(name = "JugadoresPC.findById", query = "SELECT j FROM JugadoresPC j WHERE j.id = :id"),
    @NamedQuery(name = "JugadoresPC.findByNombre", query = "SELECT j FROM JugadoresPC j WHERE j.nombre = :nombre"),
    @NamedQuery(name = "JugadoresPC.findByDescripcion", query = "SELECT j FROM JugadoresPC j WHERE j.descripcion = :descripcion"),
    @NamedQuery(name = "JugadoresPC.findByRanking", query = "SELECT j FROM JugadoresPC j WHERE j.ranking = :ranking")})
public class JugadoresPC implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "ranking")
    private Integer ranking;
    @OneToMany(mappedBy = "jugadorpc")
    private Collection<Jugadores> jugadoresCollection;

    public JugadoresPC() {
    }

    public JugadoresPC(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    @XmlTransient
    public Collection<Jugadores> getJugadoresCollection() {
        return jugadoresCollection;
    }

    public void setJugadoresCollection(Collection<Jugadores> jugadoresCollection) {
        this.jugadoresCollection = jugadoresCollection;
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
        if (!(object instanceof JugadoresPC)) {
            return false;
        }
        JugadoresPC other = (JugadoresPC) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.JugadoresPC[ id=" + id + " ]";
    }
    
}
