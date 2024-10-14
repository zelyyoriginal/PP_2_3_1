package web.services;

import web.models.User;

import java.util.List;

public interface UserService {

    public void save(User user);

    public List<User> findAll();

    public void delete(Long id);

    public User get(Long id);
}
