/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.ept.git.dic2.restfulservice.services;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import sn.ept.git.dic2.restfulservice.entities.Eleve;

/**
 *
 * @author samba
 */
@Singleton
@Startup
public class StartUpBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @EJB
    private EleveFacade eleveFacade;
    
    @PostConstruct
    public void init() {
        System.out.println("Demarrage de l' application ...");
        for (int i = 0; i < 10; i++) {
            Eleve e = new Eleve("prenom"+i, "nom"+i);
            
            eleveFacade.create(e);
            System.out.println("e = "+e);
        }
    }
}
