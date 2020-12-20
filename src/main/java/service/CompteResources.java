/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
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
import sn.ept.git.dic2.restfulservice.entities.client;
import sn.ept.git.dic2.restfulservice.entities.compte;
import sn.ept.git.dic2.restfulservice.services.AgenceFacade;
import sn.ept.git.dic2.restfulservice.services.ClientFacade;
import sn.ept.git.dic2.restfulservice.services.CompteFacade;

/**
 *
 * @author fallm
 */
@Path("compte")
@RequestScoped
public class CompteResources {
    
    @Context
    private UriInfo context;
    
    @EJB
    private CompteFacade compteFacade;

    @EJB
    private ClientFacade clientFacade;

    @EJB
    private AgenceFacade agenceFacade;

    /**
     * Creates a new instance of GenericResource
     */
    public CompteResources() {}

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String create(compte entity) {
        client client = clientFacade.find(entity.getClientId());
        agence agence = agenceFacade.find(entity.getAgenceId());
        if(client == null) {
            return "Error client don't existe !!! create client first";
        }
        if(agence == null) {
            return "Error agence don't existe !!! create agence first";
        }
        this.compteFacade.create(entity);

        return "compte create successfully !!!";
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, compte entity) {
        compteFacade.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        compteFacade.remove(compteFacade.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public compte find(@PathParam("id") Long id) {
        return compteFacade.find(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<compte> findAll() {
        return compteFacade.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<compte> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return compteFacade.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(compteFacade.count());
    }
}
