package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "users")
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int user_id;

    private String name;

    private int age;

    @OneToMany (mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Device> devices;

    public User() {

    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
        devices = new ArrayList<>();
    }

    public int getId() {
        return user_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void addDevice(Device device) {
        device.setUser(this);
        devices.add(device);
    }

    public void removeDevice(Device device) {
        devices.remove(device);
    }

    @Override
    public String toString() {
        return String.format("models.User " +
                "{id = %d, " +
                "name = %s, " +
                "age = %d}",
                user_id, name, age);
    }
}
