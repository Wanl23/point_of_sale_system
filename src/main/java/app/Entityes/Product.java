package app.Entityes;

public class Product {
    private int id;
    private String name;
    private String units;
    private int price;

    public Product(int id, String name, String units, int price) {
        this.id = id;
        this.name = name;
        this.units = units;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
