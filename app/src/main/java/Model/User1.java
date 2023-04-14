package Model;

public class User1 {
    private int id;
    private int img;
    private String name;
    private String sdt;
    private String dia_chi;

    public User1(int id, int img, String name, String sdt, String dia_chi) {
        this.id = id;
        this.img = img;
        this.name = name;
        this.sdt = sdt;
        this.dia_chi = dia_chi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDia_chi() {
        return dia_chi;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }
}
