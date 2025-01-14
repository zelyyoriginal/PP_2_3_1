package web.dao;

import web.models.User;

import java.util.List;

public interface UserDao {
    public void save(User user);

    public List<User> findAll();

    public void delete(Long id);

    public User findById(Long id);
}
