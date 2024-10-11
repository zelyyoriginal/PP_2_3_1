package web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.models.User;

import java.util.List;

@Service
public class UserServices {
    UserDao userDao;

    @Autowired
    public UserServices(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserServices() {

    }

    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    @Transactional
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Transactional
    public void delete(Long id) {
        userDao.delete(id);
    }

    @Transactional
    public User get(Long id) {
        return userDao.findById(id);
    }
}
