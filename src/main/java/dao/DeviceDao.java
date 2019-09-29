package dao;

import models.Device;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class DeviceDao implements Dao<Device> {
    private SessionFactory sessionFactory;

    public DeviceDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Device device) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(device);
        transaction.commit();
        session.close();
        System.out.println(String.format("save = %s", device.toString()));
    }

    @Override
    public void delete(Device device) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(device);
        transaction.commit();
        session.close();
        System.out.println(String.format("delete = %s", device.toString()));
    }

    @Override
    public void update(Device device) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(device);
        transaction.commit();
        session.close();
        System.out.println(String.format("update = %s", device.toString()));
    }

    @Override
    public Device findById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Device device = session.get(Device.class, id);
        transaction.commit();
        session.close();
        return device;
    }

    @Override
    public List<Device> findAll() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Device> devices = session.createQuery("From Device").list();
        transaction.commit();
        session.close();
        return devices;
    }
}
