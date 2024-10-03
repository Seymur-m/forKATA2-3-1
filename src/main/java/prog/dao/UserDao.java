package prog.dao;


import prog.model.User;

import java.util.List;

public interface UserDao {
    void save(User user);
    List<User> findAll();
    User findById(Long id);
    void update(User user);
    void delete(Long id);
}
