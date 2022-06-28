package Homework4.Advanced.Task1;

public class Spruce extends Tree implements HasCones, CanSmell {
    @Override
    public void smell() {
        System.out.println("ель: умеет пахнуть");
    }

    @Override
    public void getCones() {
        System.out.println("ель: имеет шишки");
    }
}
