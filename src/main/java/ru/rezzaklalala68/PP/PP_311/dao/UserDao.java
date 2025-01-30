package ru.rezzaklalala68.PP.PP_311.dao;

import ru.rezzaklalala68.PP.PP_311.model.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();
    User findUserById(Long id);
    void add(User user);
    void update(User user);
    void delete(Long id);
}
