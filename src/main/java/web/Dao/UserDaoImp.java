package web.Dao;

import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class UserDaoImp implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveUser(String name, String lastName, Byte age, String phoneNumber, String email) {
        entityManager.getTransaction().begin();

        User user = new User();
        user.setName(name);
        user.setLastName(lastName);
        user.setAge(age);
        user.setPhoneNumber(phoneNumber);
        user.setEmail(email);
        entityManager.persist(user);

        entityManager.getTransaction().commit();
    }

    @Override
    public User selectUserFromId(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.detach(user);
        return user;
    }

    @Override
    public List<User> getAllUser() {
        List<User> users = entityManager.createQuery("SELECT User FROM User", User.class).getResultList();
        return users;
    }

    @Override
    public void changeUserInfoById(int id, User user) {
        User user1 = selectUserFromId(id);
        user1.setName(user.getName());
        user1.setLastName(user.getLastName());
        user1.setAge(user.getAge());
        user1.setPhoneNumber(user.getPhoneNumber());
        user1.setEmail(user.getEmail());
        entityManager.merge(user1);
    }

    @Override
    public void removeUserById(User user) {
        entityManager.remove(user);
    }
}
