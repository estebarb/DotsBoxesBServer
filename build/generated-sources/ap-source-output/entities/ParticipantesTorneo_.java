package entities;

import entities.Jugadores;
import entities.Torneos;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-06-22T22:50:53")
@StaticMetamodel(ParticipantesTorneo.class)
public class ParticipantesTorneo_ { 

    public static volatile SingularAttribute<ParticipantesTorneo, Long> id;
    public static volatile SingularAttribute<ParticipantesTorneo, Torneos> torneo;
    public static volatile SingularAttribute<ParticipantesTorneo, Jugadores> jugador;

}