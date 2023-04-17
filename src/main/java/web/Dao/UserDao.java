package web.Dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void saveUser(String name, String lastName, Byte age, String phoneNumber, String email);
    User selectUserFromId(int id);
    List<User> getAllUser();
    void changeUserInfoById(int id, User user);
    void removeUserById(User user);
}
