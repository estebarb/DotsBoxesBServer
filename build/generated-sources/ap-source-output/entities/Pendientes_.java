package entities;

import entities.Juegos;
import entities.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-06-22T22:50:53")
@StaticMetamodel(Pendientes.class)
public class Pendientes_ { 

    public static volatile SingularAttribute<Pendientes, Long> id;
    public static volatile SingularAttribute<Pendientes, Usuarios> jugador;
    public static volatile SingularAttribute<Pendientes, Juegos> juego;
    public static volatile SingularAttribute<Pendientes, Boolean> turno;

}