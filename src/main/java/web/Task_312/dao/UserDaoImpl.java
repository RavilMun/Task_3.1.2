package web.Task_312.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import web.Task_312.model.User;

import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getById(Long id) {
        String jpql = "SELECT u FROM User u WHERE u.id = :id";
        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void deleteUser(Long userId) {
        User userToDelete = entityManager.find(User.class, userId);
        if (userToDelete != null) {
            entityManager.remove(userToDelete);
        }
    }

    @Override
    public List<User> index() {
        String jpql = "SELECT u FROM User u";
        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
        return query.getResultList();
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }
}
