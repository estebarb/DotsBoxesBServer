/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Esteban
 */
@Entity
@Table(name = "ParticipantesTorneo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParticipantesTorneo.findAll", query = "SELECT p FROM ParticipantesTorneo p"),
    @NamedQuery(name = "ParticipantesTorneo.findById", query = "SELECT p FROM ParticipantesTorneo p WHERE p.id = :id")})
public class ParticipantesTorneo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @JoinColumn(name = "torneo", referencedColumnName = "id")
    @ManyToOne
    private Torneos torneo;
    @JoinColumn(name = "jugador", referencedColumnName = "id")
    @ManyToOne
    private Jugadores jugador;

    public ParticipantesTorneo() {
    }

    public ParticipantesTorneo(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Torneos getTorneo() {
        return torneo;
    }

    public void setTorneo(Torneos torneo) {
        this.torneo = torneo;
    }

    public Jugadores getJugador() {
        return jugador;
    }

    public void setJugador(Jugadores jugador) {
        this.jugador = jugador;
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
        if (!(object instanceof ParticipantesTorneo)) {
            return false;
        }
        ParticipantesTorneo other = (ParticipantesTorneo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ParticipantesTorneo[ id=" + id + " ]";
    }
    
}
