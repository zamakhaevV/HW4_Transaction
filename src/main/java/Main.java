import dao.Dao;
import dao.DeviceDao;
import dao.UserDao;
import models.Device;
import models.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.HibernateSessionFactoryUtil;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        Dao<User> userDao = new UserDao(session);
        Dao<Device> deviceDao = new DeviceDao(session);
        System.out.println("=== Users ===");
        for (User user : userDao.findAll()) {
            System.out.println(user.toString());
        }
        System.out.println();

        Device updateDevice = deviceDao.findById(4);
        updateDevice.setModel("New Model");
        deviceDao.update(updateDevice);
        System.out.println();

        System.out.println("=== Devices ===");
        for (Device device : deviceDao.findAll()) {
            System.out.println(device.toString());
        }
        System.out.println();

        User saveUser = new User("Steve", 16);
        userDao.save(saveUser);

        int saveUserId = saveUser.getId();
        Device deviceMouse = new Device("Mouse", "Asus", saveUserId);
        Device deviceKeyboard = new Device("Keyboard", "Razor", saveUserId);
        deviceDao.save(deviceMouse);
        deviceDao.save(deviceKeyboard);
        System.out.println();

        System.out.println("=== Users ===");
        for (User user : userDao.findAll()) {
            System.out.println(user.toString());
        }
        System.out.println();

        System.out.println("=== Devices ===");
        for (Device device : deviceDao.findAll()) {
            System.out.println(device.toString());
        }
        System.out.println();

        User deleteUser = userDao.findById(1);
        userDao.delete(deleteUser);
        System.out.println();

        System.out.println("=== Users ===");
        for (User user : userDao.findAll()) {
            System.out.println(user.toString());
        }
        System.out.println();

        System.out.println("=== Devices ===");
        for (Device device : deviceDao.findAll()) {
            System.out.println(device.toString());
        }
        System.out.println();
    }
}
