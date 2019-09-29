import dao.Dao;
import dao.DeviceDao;
import dao.UserDao;
import models.Device;
import models.User;

import org.hibernate.SessionFactory;
import utils.HibernateSessionFactoryUtil;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();

        Dao<User> userDao = new UserDao(sessionFactory);

        System.out.println("=== Users ===");
        for (User user : userDao.findAll()) {
            System.out.println(user.toString());
        }
        System.out.println();

        Dao<Device> deviceDao = new DeviceDao(sessionFactory);

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
        Device deviceMouse = new Device("Mouse", "Asus");
        Device deviceKeyboard = new Device("Keyboard", "Razor");
        saveUser.addDevice(deviceMouse);
        saveUser.addDevice(deviceKeyboard);
        userDao.save(saveUser);
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
