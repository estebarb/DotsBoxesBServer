package entities;

import entities.Ganadores;
import entities.Jugadores;
import entities.Jugadoresjuego;
import entities.Pendientes;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-06-23T23:39:58")
@StaticMetamodel(Juegos.class)
public class Juegos_ { 

    public static volatile SingularAttribute<Juegos, Long> id;
    public static volatile SingularAttribute<Juegos, BigInteger> torneo;
    public static volatile SingularAttribute<Juegos, Integer> filas;
    public static volatile SingularAttribute<Juegos, Date> fecha;
    public static volatile SingularAttribute<Juegos, Jugadores> ganador;
    public static volatile CollectionAttribute<Juegos, Jugadoresjuego> jugadoresjuegoCollection;
    public static volatile SingularAttribute<Juegos, Integer> turnoactual;
    public static volatile SingularAttribute<Juegos, byte[]> tablero;
    public static volatile CollectionAttribute<Juegos, Ganadores> ganadoresCollection;
    public static volatile SingularAttribute<Juegos, Boolean> isterminado;
    public static volatile SingularAttribute<Juegos, Integer> columnas;
    public static volatile CollectionAttribute<Juegos, Pendientes> pendientesCollection;

}