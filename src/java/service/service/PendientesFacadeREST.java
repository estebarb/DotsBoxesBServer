/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.service;

import entities.Pendientes;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import utils.EMF;

/**
 *
 * @author Esteban
 */
//@javax.ejb.Stateless
@Path("entities.pendientes")
public class PendientesFacadeREST extends AbstractFacade<Pendientes> {
    @PersistenceContext(unitName = "DotsBoxesBServerPU")
    private EntityManager em;

    public PendientesFacadeREST() {
        super(Pendientes.class);
        em = EMF.createEntityManager();
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Pendientes entity) {
        super.create(entity);
    }

    @PUT
    @Override
    @Consumes({"application/xml", "application/json"})
    public void edit(Pendientes entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Pendientes find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Pendientes> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Pendientes> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
