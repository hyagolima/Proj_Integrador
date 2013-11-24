/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Microfone;

/**
 *
 * @author Tiago
 */
@Stateless
public class MicrofoneFacade extends AbstractFacade<Microfone> {
    @PersistenceContext(unitName = "Proj_IntegradorPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MicrofoneFacade() {
        super(Microfone.class);
    }
    
}
