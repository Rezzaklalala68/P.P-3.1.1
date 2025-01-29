package ru.rezzaklalala68.PP.PP_311.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.rezzaklalala68.PP.PP_311.model.User;

import java.util.List;
@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> getUsers() {
        return entityManager.createQuery("from User ", User.class).getResultList();
    }
    public void add(User user) {
        entityManager.persist(user);
    }
    public User findUserById(Long id) {
        return entityManager.find(User.class, id);
    }
    public void update(User user) {
        User userToUpdate = entityManager.find(User.class, user.getId());
        if(userToUpdate != null) {
            userToUpdate.setFirstName(user.getFirstName());
            userToUpdate.setLastName(user.getLastName());
            userToUpdate.setAge(user.getAge());
            entityManager.merge(userToUpdate);
        }


    }
    public void delete(User user) {
        User userToDelete = entityManager.find(User.class, user.getId());
        if (userToDelete != null) {
            entityManager.remove(userToDelete);
        }

    }
}
