/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundaries;

import java.security.Principal;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entities.User;
import javax.persistence.EntityExistsException;


/**
 *
 * @author doc
 */
@Stateless
public class UserManager {
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    Principal principal;

    public void save(User user) {
        if (em.find(User.class, user.getEmail())==null){
            em.persist(user);
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public void unregister() {
        em.remove(getLoggedUser());
    }

    public User getLoggedUser() {
        return em.find(User.class, principal.getName());
    }
    
    public boolean checkExist(String email){
        
        
        
        return false;
    }
}
