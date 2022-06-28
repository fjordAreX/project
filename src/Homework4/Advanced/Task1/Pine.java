package Homework4.Advanced.Task1;

public class Pine extends Tree implements HasCones, CanSmell {
    @Override
    public void smell() {
        System.out.println("сосна: умеет пахнуть");
    }

    @Override
    public void getCones() {
        System.out.println("сосна: имеет шишки");
    }
}
