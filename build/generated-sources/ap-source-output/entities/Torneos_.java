package entities;

import entities.ParticipantesTorneo;
import entities.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-06-22T22:50:53")
@StaticMetamodel(Torneos.class)
public class Torneos_ { 

    public static volatile SingularAttribute<Torneos, Long> id;
    public static volatile SingularAttribute<Torneos, Integer> tipotorneo;
    public static volatile SingularAttribute<Torneos, String> nombretorneo;
    public static volatile CollectionAttribute<Torneos, ParticipantesTorneo> participantesTorneoCollection;
    public static volatile SingularAttribute<Torneos, Integer> numparticipantes;
    public static volatile SingularAttribute<Torneos, Usuarios> administrador;

}