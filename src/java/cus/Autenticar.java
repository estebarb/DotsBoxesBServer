package cus;

import entities.Usuarios;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Esteban
 */
public class Autenticar {
    @PersistenceContext(unitName = "DotsBoxesBServerPU")
    private EntityManager em;
    
    public boolean AutenticarUsuario(String usuario, String password){
        List<Usuarios> users = em.createNamedQuery("Usuarios.findByEmail")
                .setParameter("email", usuario)
                .getResultList();
        
        // TODO: Agregar seguridad al password
        String passHash = password;
        boolean resultado = false;
        
        for(Usuarios u : users){
            if(u.getPasswordhash() == passHash){
                resultado = true;
            }
        }
        return resultado;
    }
}
