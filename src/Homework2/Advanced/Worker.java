package Homework2.Advanced;

public class Worker {
    private String name;
    private int damagedProducts;
    private Warehouse warehouse;

    public Worker(String name, Warehouse warehouse) {
        this.name = name;
        this.damagedProducts = 0;
        this.warehouse = warehouse;
    }

    @Override
    public String toString() {
        return "Товарищ " + name + " работает на складе по адресу "
                + this.warehouse.getAddress()+ " и испортил "+ damagedProducts
                + " единиц(ы) водки";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamagedProducts() {
        return damagedProducts;
    }

    private void setDamagedProducts(int damagedProducts) {
        this.damagedProducts = damagedProducts;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public void damageProducts(int quantity){

        if (this.warehouse.getQuantity()>=quantity && quantity>0) {
            this.warehouse.setQuantity(this.warehouse.getQuantity() - quantity);
            setDamagedProducts(quantity);
            System.out.println("Ура я испортил водку!");
        }else {
            System.out.println("Невозможно испортить столько водки");
        }

    }

}
