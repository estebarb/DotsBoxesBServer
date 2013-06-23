package entities;

import entities.Equipos;
import entities.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-06-22T22:50:53")
@StaticMetamodel(MiembrosEquipo.class)
public class MiembrosEquipo_ { 

    public static volatile SingularAttribute<MiembrosEquipo, Long> id;
    public static volatile SingularAttribute<MiembrosEquipo, Equipos> equipo;
    public static volatile SingularAttribute<MiembrosEquipo, Usuarios> jugador;

}