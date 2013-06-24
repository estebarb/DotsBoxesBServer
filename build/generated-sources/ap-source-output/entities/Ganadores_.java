package entities;

import entities.Juegos;
import entities.Jugadores;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-06-23T23:39:58")
@StaticMetamodel(Ganadores.class)
public class Ganadores_ { 

    public static volatile SingularAttribute<Ganadores, Long> id;
    public static volatile CollectionAttribute<Ganadores, Jugadores> jugadoresCollection;
    public static volatile SingularAttribute<Ganadores, Juegos> juego;

}