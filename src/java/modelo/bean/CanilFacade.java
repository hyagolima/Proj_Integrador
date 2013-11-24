/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Canil;

/**
 *
 * @author Tiago
 */
@Stateless
public class CanilFacade extends AbstractFacade<Canil> {
    @PersistenceContext(unitName = "Proj_IntegradorPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CanilFacade() {
        super(Canil.class);
    }
    
}
