package Model;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String user;
    private String pass;
    private int old;
    private String address;
    private String phone;
    private String img;

    public User(int id, String user, String pass, int old, String address, String phone, String avatar) {
        this.id = id;
        this.user = user;
        this.pass = pass;
        this.old = old;
        this.address = address;
        this.phone = phone;
        this.img = avatar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getOld() {
        return old;
    }

    public void setOld(int old) {
        this.old = old;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatar() {
        return img;
    }

    public void setAvatar(String avatar) {
        this.img = avatar;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", pass='" + pass + '\'' +
                ", old=" + old +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", avatar='" + img + '\'' +
                '}';
    }
}
