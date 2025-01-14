package web.dao;

import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager manager;

    public UserDaoImpl() {
    }


    public void save(User user) {
        manager.merge(user);
    }

    public List<User> findAll() {
        return manager.createQuery("from User").getResultList();
    }

    public void delete(Long id) {
        manager.createQuery("delete from User where id = :id").setParameter("id", id).executeUpdate();

    }

    public User findById(Long id) {
        return manager.find(User.class, id);
    }

}
