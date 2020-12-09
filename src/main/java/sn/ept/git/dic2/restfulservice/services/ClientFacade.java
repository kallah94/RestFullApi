/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.ept.git.dic2.restfulservice.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sn.ept.git.dic2.restfulservice.entities.client;

/**
 *
 * @author fallm
 */
@Stateless
public class ClientFacade extends AbstractFacade<client> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public ClientFacade() {
        super(client.class);
    }
    
}
