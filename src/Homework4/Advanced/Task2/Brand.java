package Homework4.Advanced.Task2;

public class Brand {
    private String name;
    private Shop[] shops;

    public Brand(String name, Shop[] shops) {
        this.name = name;
        this.shops = shops;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Shop[] getShops() {
        return shops;
    }

    public void setShops(Shop[] shops) {
        this.shops = shops;
    }
}
