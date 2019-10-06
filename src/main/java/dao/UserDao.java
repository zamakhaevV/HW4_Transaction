package dao;

import models.Device;
import models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDao implements Dao<User> {
    private Session session;

    public UserDao(Session session) {
        this.session = session;
    }

    @Override
    public void save(User user) {
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        System.out.println(String.format("save = %s", user.toString()));
    }

    @Override
    public void delete(User user) {
        Transaction transaction = session.beginTransaction();
        List<Device> devices = session
                .createQuery(String.format("FROM Device D WHERE D.user_id = %d", user.getId()))
                .list();
        if (devices != null) {
            for (Device device : devices) {
                session.delete(device);
            }
        }
        session.delete(user);
        transaction.commit();
        System.out.println(String.format("delete = %s", user.toString()));
    }

    @Override
    public void update(User user) {
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        System.out.println(String.format("update = %s", user.toString()));
    }

    @Override
    public User findById(int id) {
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, id);
        transaction.commit();
        return user;
    }

    @Override
    public List<User> findAll() {
        Transaction transaction = session.beginTransaction();
        List<User> users = session.createQuery("From User").list();
        transaction.commit();
        return users;
    }
}
