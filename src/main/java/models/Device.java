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

    private int user_id;

    public Device() {

    }

    public Device(String type, String model, int user_id) {
        this.type = type;
        this.model = model;
        this.user_id = user_id;
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

    public int getUser_id() {
        return user_id;
    }

    @Override
    public String toString() {
        return String.format("models.Device " +
                        "{id = %d, " +
                        "type = %s, " +
                        "model = %s, " +
                        "user_id = %d}",
                device_id, type, model, user_id);
    }
}
