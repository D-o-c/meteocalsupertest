/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import boundaries.UserManager;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


/**
 *
 * @author doc
 */
@Named
@RequestScoped
public class UserBean {

    @EJB
    UserManager um;
    
    public UserBean() {
    }
    
    public String getName() {
        return um.getLoggedUser().getName();
    }
    
}
