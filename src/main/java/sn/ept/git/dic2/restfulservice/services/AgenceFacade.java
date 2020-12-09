/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.ept.git.dic2.restfulservice.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sn.ept.git.dic2.restfulservice.entities.agence;

/**
 *
 * @author fallm
 */
@Stateless
public class AgenceFacade extends AbstractFacade<agence> {
 
    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
       return em;
    }
    
    public AgenceFacade() {
        super(agence.class);
    }
}
