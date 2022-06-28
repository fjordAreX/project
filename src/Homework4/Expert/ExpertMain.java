package Homework4.Expert;

public class ExpertMain {
    public static void main(String[] args) {

        System.out.println("Задание 1");

        Human human = Human.builder().name("Петя").age(20).weight(80).build();
        human.info();

        System.out.println("\nЗадание 2");

        CarShop carShop = new CarShop(new Car(1000));
        carShop.sellCar();
    }
}
