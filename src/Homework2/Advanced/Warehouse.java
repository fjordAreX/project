package Homework2.Advanced;

public class Warehouse {
    private String address;
    private int quantity;

    public Warehouse(String address, int quantity) {
        this.address = address;
        if (quantity >= 0) {
            this.quantity = quantity;
        } else {
            this.quantity = 0;
            System.out.println("На складе не может быть столько водки - установлено значение 0");
        }
    }

    @Override
    public String toString() {
        return "Склад по адресу "+ address + " имеет " + quantity + " единиц(ы) водки";
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (this.quantity==0 || quantity>this.quantity || quantity<0){
            System.out.println("Операция невозможна.");
        } else {
            this.quantity = quantity;
        }
    }

}
