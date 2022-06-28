package Homework4.Expert;

public class Human {
    private int age;
    private String name;
    private double weight;


    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    private Human() {
    }

    public static HumanBuilder builder() {
        return new HumanBuilder();
    }

    public void info() {
        System.out.println(name + " - возраст: " + age + ", вес: " + weight);
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    static class HumanBuilder {
        private final Human human = new Human();

        public HumanBuilder name(String settingName) {
            human.setName(settingName);
            return this;
        }

        public HumanBuilder age(int settingAge) {
            human.setAge(settingAge);
            return this;
        }

        public HumanBuilder weight(double settingWeight) {
            human.setWeight(settingWeight);
            return this;
        }

        public Human build() {
            return human;
        }
    }
}
