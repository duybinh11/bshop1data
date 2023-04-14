package Model;

public class ItemCart {
    private int img;
    private int id;
    private String name;
    private int cost;
    private int sl;

    public ItemCart(int img, int id, String name, int cost, int sl) {
        this.img = img;
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.sl = sl;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }
}
