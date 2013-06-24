package entities;

import entities.Participantestorneo;
import entities.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-06-23T23:39:58")
@StaticMetamodel(Torneos.class)
public class Torneos_ { 

    public static volatile SingularAttribute<Torneos, Long> id;
    public static volatile SingularAttribute<Torneos, Integer> tipotorneo;
    public static volatile CollectionAttribute<Torneos, Participantestorneo> participantestorneoCollection;
    public static volatile SingularAttribute<Torneos, String> nombretorneo;
    public static volatile SingularAttribute<Torneos, Integer> numparticipantes;
    public static volatile SingularAttribute<Torneos, Usuarios> administrador;

}