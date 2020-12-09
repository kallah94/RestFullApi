/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import sn.ept.git.dic2.restfulservice.entities.client;
import sn.ept.git.dic2.restfulservice.entities.compte;
import sn.ept.git.dic2.restfulservice.services.ClientFacade;
import sn.ept.git.dic2.restfulservice.services.CompteFacade;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.util.List;

/**
 * @author fallm
 */

@Path("client")
@RequestScoped
public class ClientResources {
    
    @Context
    private UriInfo context;

    @EJB
    private ClientFacade clientFacade;

    @EJB
    private CompteFacade compteFacade;

    public ClientResources() {}

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String create(client entity) {
        clientFacade.create(entity);
        return "Client created successfully !!!";
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String edit(@PathParam("id") Long id, client entity) {
         clientFacade.edit(entity);
         return "Client updated successfully !!!";
    }

    @DELETE
    @Path("{id}")
    public String remove(@PathParam("id") Long id) {
         clientFacade.remove( clientFacade.find(id));
         return "Client  d' "+id+"is removed successfully";
                 
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public client find(@PathParam("id") Long id) {
        return  clientFacade.find(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<client> findAll() {
        return  clientFacade.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<client> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return  clientFacade.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf( clientFacade.count());
    }

    @GET
    @Path("{id}/comptes")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<compte> userComptes(@PathParam("id") Long id) {
        List<compte> comptes = compteFacade.findAll();
        comptes.forEach(compte -> {
            if(compte.getClientId() != id) {
                comptes.remove(compte);
            }
        });
        return comptes;
    }

    @GET
    @Path("{id}/comptes/{id_compte}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public compte getCompte(@PathParam("id") Long id, @PathParam("id_compte") Long idCompte) {
        compte singleCompte = compteFacade.find(idCompte);
        return (singleCompte.getClientId() == id) ? singleCompte : null;
    }
}
