/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Juegos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Juegos.findAll", query = "SELECT j FROM Juegos j"),
    @NamedQuery(name = "Juegos.findById", query = "SELECT j FROM Juegos j WHERE j.id = :id"),
    @NamedQuery(name = "Juegos.findByIsterminado", query = "SELECT j FROM Juegos j WHERE j.isterminado = :isterminado"),
    @NamedQuery(name = "Juegos.findByTurnoactual", query = "SELECT j FROM Juegos j WHERE j.turnoactual = :turnoactual"),
    @NamedQuery(name = "Juegos.findByFecha", query = "SELECT j FROM Juegos j WHERE j.fecha = :fecha"),
    @NamedQuery(name = "Juegos.findByTorneo", query = "SELECT j FROM Juegos j WHERE j.torneo = :torneo")})
public class Juegos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "isterminado")
    private Boolean isterminado;
    @Column(name = "turnoactual")
    private Integer turnoactual;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "torneo")
    private BigInteger torneo;
    @OneToMany(mappedBy = "juego")
    private Collection<Ganadores> ganadoresCollection;
    @OneToMany(mappedBy = "juego")
    private Collection<Pendientes> pendientesCollection;
    @JoinColumn(name = "ganador", referencedColumnName = "id")
    @ManyToOne
    private Jugadores ganador;
    @OneToMany(mappedBy = "juego")
    private Collection<JugadoresJuego> jugadoresJuegoCollection;

    public Juegos() {
    }

    public Juegos(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getIsterminado() {
        return isterminado;
    }

    public void setIsterminado(Boolean isterminado) {
        this.isterminado = isterminado;
    }

    public Integer getTurnoactual() {
        return turnoactual;
    }

    public void setTurnoactual(Integer turnoactual) {
        this.turnoactual = turnoactual;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigInteger getTorneo() {
        return torneo;
    }

    public void setTorneo(BigInteger torneo) {
        this.torneo = torneo;
    }

    @XmlTransient
    public Collection<Ganadores> getGanadoresCollection() {
        return ganadoresCollection;
    }

    public void setGanadoresCollection(Collection<Ganadores> ganadoresCollection) {
        this.ganadoresCollection = ganadoresCollection;
    }

    @XmlTransient
    public Collection<Pendientes> getPendientesCollection() {
        return pendientesCollection;
    }

    public void setPendientesCollection(Collection<Pendientes> pendientesCollection) {
        this.pendientesCollection = pendientesCollection;
    }

    public Jugadores getGanador() {
        return ganador;
    }

    public void setGanador(Jugadores ganador) {
        this.ganador = ganador;
    }

    @XmlTransient
    public Collection<JugadoresJuego> getJugadoresJuegoCollection() {
        return jugadoresJuegoCollection;
    }

    public void setJugadoresJuegoCollection(Collection<JugadoresJuego> jugadoresJuegoCollection) {
        this.jugadoresJuegoCollection = jugadoresJuegoCollection;
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
        if (!(object instanceof Juegos)) {
            return false;
        }
        Juegos other = (Juegos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Juegos[ id=" + id + " ]";
    }
    
}
