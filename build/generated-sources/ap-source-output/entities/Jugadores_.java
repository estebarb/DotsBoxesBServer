package entities;

import entities.Equipos;
import entities.Ganadores;
import entities.Juegos;
import entities.JugadoresJuego;
import entities.JugadoresPC;
import entities.ParticipantesTorneo;
import entities.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-06-22T22:50:53")
@StaticMetamodel(Jugadores.class)
public class Jugadores_ { 

    public static volatile SingularAttribute<Jugadores, Long> id;
    public static volatile SingularAttribute<Jugadores, Equipos> equipo;
    public static volatile SingularAttribute<Jugadores, Usuarios> usuario;
    public static volatile SingularAttribute<Jugadores, Ganadores> ganador;
    public static volatile CollectionAttribute<Jugadores, ParticipantesTorneo> participantesTorneoCollection;
    public static volatile CollectionAttribute<Jugadores, Juegos> juegosCollection;
    public static volatile CollectionAttribute<Jugadores, JugadoresJuego> jugadoresJuegoCollection;
    public static volatile SingularAttribute<Jugadores, Integer> type;
    public static volatile SingularAttribute<Jugadores, JugadoresPC> jugadorpc;

}