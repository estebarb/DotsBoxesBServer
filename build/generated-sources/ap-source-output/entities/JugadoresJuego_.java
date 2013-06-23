package entities;

import entities.Juegos;
import entities.Jugadores;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-06-22T22:50:53")
@StaticMetamodel(JugadoresJuego.class)
public class JugadoresJuego_ { 

    public static volatile SingularAttribute<JugadoresJuego, Long> id;
    public static volatile SingularAttribute<JugadoresJuego, Jugadores> jugador;
    public static volatile SingularAttribute<JugadoresJuego, Juegos> juego;
    public static volatile SingularAttribute<JugadoresJuego, Integer> puntaje;

}