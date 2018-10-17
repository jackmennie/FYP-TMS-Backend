package services;

import core.TrustManagementSystem;
import models.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.*;

@Stateless
public class UserService {
    //@PersistenceContext
    //private EntityManager em;

    public List<User> getAll() {

        return null;
    }

    public void add(User user) {
        //list.add(user);
    }
}
