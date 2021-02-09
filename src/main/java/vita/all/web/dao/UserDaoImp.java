package vita.all.web.dao;

import vita.all.web.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        System.out.println("getAll users");
        return entityManager.createQuery("from User").getResultList();
    }

    @Override
    public User getUserById(Long id) {
        System.out.println("getUser by Id");
        TypedQuery<User> query = entityManager.createQuery(
                "SELECT user FROM User user WHERE user.id = :id", User.class);
        User user = query
                .setParameter("id", id)
                .getSingleResult();
        return user;
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public User update(Long id, User updatedUser) {
        return entityManager.merge(updatedUser);
        /*        User userToBeUpdated = getUserById(id);
        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setAge(updatedUser.getAge());*/
    }

    @Override
    public User getUserByName(String s) {
       return entityManager.createQuery("FROM User where name=:name", User.class).
               setParameter("name", s).getSingleResult();
    }


}

