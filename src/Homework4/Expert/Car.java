package Homework4.Expert;

public class Car {
    private int price;

    public int getPrice() throws Exception {
        if (price < 0) {
            throw new Exception("price cant be negative");
        }
        return price;
    }

    public Car(int price) {
        this.price = price;
    }
}
