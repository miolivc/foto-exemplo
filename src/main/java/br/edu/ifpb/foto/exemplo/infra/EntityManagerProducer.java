/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.foto.exemplo.infra;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author recursivejr
 */
public class EntityManagerProducer {
    
    @Produces
    public EntityManager getEntityManager() {
        return Persistence.createEntityManagerFactory("foto-exemplo").createEntityManager();
    }
    
}
