package web.service;

import org.springframework.stereotype.Service;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveUser(String name, String lastName, Byte age, String phoneNumber, String email) {
        entityManager.persist(new User(name, lastName, age, phoneNumber, email));
    }

    @Override
    public User selectUserFromId(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getAllUser() {
        return entityManager.createQuery("SELECT User FROM User", User.class).getResultList();
    }

    @Override
    public void changeUserInfoById(int id, User user) {
        User user1 = entityManager.find(User.class, id);
        user1.setName(user.getName());
        user1.setLastName(user.getLastName());
        user1.setAge(user.getAge());
        user1.setPhoneNumber(user.getPhoneNumber());
        user1.setEmail(user.getEmail());
        entityManager.merge(user1);
    }

    @Override
    public void removeUser(User user) {
        entityManager.remove(user);
    }
}
