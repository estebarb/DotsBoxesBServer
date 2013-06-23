package entities;

import entities.Jugadores;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-06-22T22:50:53")
@StaticMetamodel(JugadoresPC.class)
public class JugadoresPC_ { 

    public static volatile SingularAttribute<JugadoresPC, Long> id;
    public static volatile SingularAttribute<JugadoresPC, String> nombre;
    public static volatile CollectionAttribute<JugadoresPC, Jugadores> jugadoresCollection;
    public static volatile SingularAttribute<JugadoresPC, String> descripcion;
    public static volatile SingularAttribute<JugadoresPC, Integer> ranking;

}