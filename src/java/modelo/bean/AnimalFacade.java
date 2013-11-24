/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.bean;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.Animal;
import modelo.controller.PessoaController;

/**
 *
 * @author Tiago
 */
@Stateless
public class AnimalFacade extends AbstractFacade<Animal> {
    @PersistenceContext(unitName = "Proj_IntegradorPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List animaisCpf(String cpf) {
        try {
            Query qry;
            
            qry = em.createNamedQuery("Animal.findByCpf").setParameter("idCpf", cpf);
            return (List<Animal>) qry.getResultList();
            //return (Entidade) qry.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public AnimalFacade() {
        super(Animal.class);
    }
    
}
