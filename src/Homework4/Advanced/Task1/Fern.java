package Homework4.Advanced.Task1;

public class Fern extends Plant implements CanBloom {
    @Override
    public void bloom() {
        System.out.println("папоротник: умеет цвести");
    }
}
