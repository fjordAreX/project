package Homework2.Basic;

public class BasicMain {
    public static void main(String[] args) {
        System.out.println("Задание 1");

        for (int i = 1; i <=100 ; i++) {
            System.out.print(i+"a ");
        }

        System.out.println("\n\nЗадание 2");

        int ageChildren = 10;

        if(ageChildren<6){
            System.out.println("пошел в сад");
        }else if (ageChildren<11){
            System.out.println("пошел в младшую школу");
        }else if (ageChildren<17){
            System.out.println("пошел в среднюю школу");
        }else {
            System.out.println("пошел в университет");
        }

        System.out.println("\nЗадание 3");

        boolean chicken = true;
        boolean vegetables = false;
        boolean sour = true;
        boolean toast = true;
        boolean sausage = true;
        boolean eggs = true;

        if (chicken && vegetables && sour && toast){
            System.out.println("Салат Цезарь готов");

        } else if(vegetables && sausage && chicken && eggs){
            System.out.println("Салат Оливье готов");

        }else if (vegetables) {
            System.out.println("Овощной салат готов");

        }else {
            System.out.println("Невозможно приготовить салат");
        }

        System.out.println("\nЗадание 4");

        Dog dog = new Dog("Sharpi","Red");
        System.out.println("Old name is "+dog.getName());
        System.out.println("Old color is "+dog.getColor());
        dog.setName("Barcelona");
        dog.setColor("White");
        System.out.println(dog);

        System.out.println();

        Cat cat = new Cat("Barsik","Black");
        System.out.println("Old name is  "+cat.getName());
        System.out.println("Old color is "+cat.getColor());
        cat.setName("Garfield");
        cat.setColor("Orange");
        System.out.println(cat);
    }
}
