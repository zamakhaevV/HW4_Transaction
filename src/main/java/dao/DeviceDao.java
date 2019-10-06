package dao;

import models.Device;
import models.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DeviceDao implements Dao<Device> {
    private Session session;

    public DeviceDao(Session session) {
        this.session = session;
    }

    @Override
    public void save(Device device) {
        Transaction transaction = session.beginTransaction();
        if (session.get(User.class, device.getUser_id()) != null) {
            session.save(device);
        } else {
            throw new HibernateException("user doesn't exist");
        }
        transaction.commit();
        System.out.println(String.format("save = %s", device.toString()));
    }

    @Override
    public void delete(Device device) {
        Transaction transaction = session.beginTransaction();
        session.delete(device);
        transaction.commit();
        System.out.println(String.format("delete = %s", device.toString()));
    }

    @Override
    public void update(Device device) {
        Transaction transaction = session.beginTransaction();
        session.update(device);
        transaction.commit();
        System.out.println(String.format("update = %s", device.toString()));
    }

    @Override
    public Device findById(int id) {
        Transaction transaction = session.beginTransaction();
        Device device = session.get(Device.class, id);

        transaction.commit();
        return device;
    }

    @Override
    public List<Device> findAll() {
        Transaction transaction = session.beginTransaction();
        List<Device> devices = session
                .createQuery("From Device")
                .list();
        transaction.commit();
        return devices;
    }
}
