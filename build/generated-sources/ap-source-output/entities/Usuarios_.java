package entities;

import entities.Jugadores;
import entities.Miembrosequipo;
import entities.Pendientes;
import entities.Torneos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-06-23T23:39:58")
@StaticMetamodel(Usuarios.class)
public class Usuarios_ { 

    public static volatile SingularAttribute<Usuarios, Long> id;
    public static volatile SingularAttribute<Usuarios, String> nombre;
    public static volatile CollectionAttribute<Usuarios, Miembrosequipo> miembrosequipoCollection;
    public static volatile CollectionAttribute<Usuarios, Jugadores> jugadoresCollection;
    public static volatile SingularAttribute<Usuarios, String> email;
    public static volatile SingularAttribute<Usuarios, Date> lastlogin;
    public static volatile CollectionAttribute<Usuarios, Torneos> torneosCollection;
    public static volatile CollectionAttribute<Usuarios, Pendientes> pendientesCollection;
    public static volatile SingularAttribute<Usuarios, String> password;
    public static volatile SingularAttribute<Usuarios, Integer> ranking;
    public static volatile SingularAttribute<Usuarios, String> salt;

}