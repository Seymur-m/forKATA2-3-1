package prog.service;


import prog.model.User;

import java.util.List;

public interface UserService {
    void save(User user);
    List<User> findAll();
    User findById(Long id);
    void update(User user);
    void delete(Long id);
}
