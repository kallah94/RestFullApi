/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import sn.ept.git.dic2.restfulservice.entities.agence;
import sn.ept.git.dic2.restfulservice.entities.compte;
import sn.ept.git.dic2.restfulservice.services.AgenceFacade;
import sn.ept.git.dic2.restfulservice.services.CompteFacade;

/**
 *
 * @author fallm
 */
@Path("agence")
@RequestScoped
public class AgenceResources {
    
    @Context
    private UriInfo context;
    
    @EJB
    private AgenceFacade agenceFacade;

    @EJB
    private CompteFacade compteFacade;

    public AgenceResources() {}

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String create(agence entity) {
        agenceFacade.create(entity);
        return "Agence created Successfully !!!!";
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String edit(@PathParam("id") Long id, agence entity) {
        agenceFacade.edit(entity);
        return "Agence d'"+id+"updated Successfully !!!";
    }

    @DELETE
    @Path("{id}")
    public String remove(@PathParam("id") Long id) {
        agenceFacade.remove(agenceFacade.find(id));
        return "Agence d'"+id+"reomoved Successfully";
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public agence find(@PathParam("id") Long id) {
        return agenceFacade.find(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<agence> getAgences() {
        return agenceFacade.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<agence> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return agenceFacade.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(agenceFacade.count());
    }


    @GET
    @Path("{id}/comptes")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<compte> userComptes(@PathParam("id") Long id) {
        List<compte> comptes = compteFacade.findAll();
        comptes.forEach(compte -> {
            if(compte.getAgenceId() != id) {
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
        return (singleCompte.getAgenceId() == id) ? singleCompte : null;
    }

}
