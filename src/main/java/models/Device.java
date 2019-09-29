package models;


import javax.persistence.*;

@Entity
@Table (name = "devices")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int device_id;

    private String type;

    private String model;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public Device() {

    }

    public Device(String type, String model) {
        this.type = type;
        this.model = model;
    }

    public int getId() {
        return device_id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return String.format("models.Device " +
                        "{id = %d, " +
                        "type = %s, " +
                        "model = %s, " +
                        "user_id = %d}",
                device_id, type, model, user.getId());
    }
}
