package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void saveUser(String name, String lastName, Byte age, String phoneNumber, String email);
    User selectUserFromId(int id);
    List<User> getAllUser();
    void changeUserInfoById(int id, User user);
    void removeUser(User user);
}
