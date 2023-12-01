package web.Task_312.service;


import web.Task_312.model.User;

import java.util.List;

public interface UserService {
    void create(User user);

    List<User> index();

    void delete(Long id);

    User getById(Long id);

    void update(User user);
}
