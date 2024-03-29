/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import boundaries.UserManager;
import entities.User;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityExistsException;

/**
 *
 * @author doc
 */
@Named(value = "registrationBean")
@RequestScoped
public class RegistrationBean {

    @EJB
    private UserManager um;

    private User user;

    public RegistrationBean() {
    }

    public User getUser() {
        if (user == null) {
            user = new User();
        }
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String register() {
        try{
            um.save(user);
        }
        catch(IllegalArgumentException e){
           return "sticazzi";
        }
        //return "user/home?faces-redirect=true";
        return "";
    }

}
