package web.Task_312.dao;


import web.Task_312.model.User;

import java.util.List;

public interface UserDao {

    void addUser(User user);

    User getById(Long id);

    void deleteUser(Long userId);

    List<User> index();

    void updateUser(User user);

}
