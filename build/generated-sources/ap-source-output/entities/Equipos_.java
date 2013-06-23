package entities;

import entities.Jugadores;
import entities.MiembrosEquipo;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-06-22T22:50:53")
@StaticMetamodel(Equipos.class)
public class Equipos_ { 

    public static volatile SingularAttribute<Equipos, Long> id;
    public static volatile SingularAttribute<Equipos, String> nombre;
    public static volatile CollectionAttribute<Equipos, Jugadores> jugadoresCollection;
    public static volatile SingularAttribute<Equipos, Integer> ranking;
    public static volatile CollectionAttribute<Equipos, MiembrosEquipo> miembrosEquipoCollection;

}