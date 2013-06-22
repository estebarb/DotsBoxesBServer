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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Torneos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Torneos.findAll", query = "SELECT t FROM Torneos t"),
    @NamedQuery(name = "Torneos.findById", query = "SELECT t FROM Torneos t WHERE t.id = :id"),
    @NamedQuery(name = "Torneos.findByTipotorneo", query = "SELECT t FROM Torneos t WHERE t.tipotorneo = :tipotorneo"),
    @NamedQuery(name = "Torneos.findByNumparticipantes", query = "SELECT t FROM Torneos t WHERE t.numparticipantes = :numparticipantes"),
    @NamedQuery(name = "Torneos.findByNombretorneo", query = "SELECT t FROM Torneos t WHERE t.nombretorneo = :nombretorneo")})
public class Torneos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "tipotorneo")
    private Integer tipotorneo;
    @Column(name = "numparticipantes")
    private Integer numparticipantes;
    @Basic(optional = false)
    @Column(name = "nombretorneo")
    private String nombretorneo;
    @OneToMany(mappedBy = "torneo")
    private Collection<ParticipantesTorneo> participantesTorneoCollection;
    @JoinColumn(name = "administrador", referencedColumnName = "id")
    @ManyToOne
    private Usuarios administrador;

    public Torneos() {
    }

    public Torneos(Long id) {
        this.id = id;
    }

    public Torneos(Long id, String nombretorneo) {
        this.id = id;
        this.nombretorneo = nombretorneo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTipotorneo() {
        return tipotorneo;
    }

    public void setTipotorneo(Integer tipotorneo) {
        this.tipotorneo = tipotorneo;
    }

    public Integer getNumparticipantes() {
        return numparticipantes;
    }

    public void setNumparticipantes(Integer numparticipantes) {
        this.numparticipantes = numparticipantes;
    }

    public String getNombretorneo() {
        return nombretorneo;
    }

    public void setNombretorneo(String nombretorneo) {
        this.nombretorneo = nombretorneo;
    }

    @XmlTransient
    public Collection<ParticipantesTorneo> getParticipantesTorneoCollection() {
        return participantesTorneoCollection;
    }

    public void setParticipantesTorneoCollection(Collection<ParticipantesTorneo> participantesTorneoCollection) {
        this.participantesTorneoCollection = participantesTorneoCollection;
    }

    public Usuarios getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Usuarios administrador) {
        this.administrador = administrador;
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
        if (!(object instanceof Torneos)) {
            return false;
        }
        Torneos other = (Torneos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Torneos[ id=" + id + " ]";
    }
    
}
