package Homework2.Basic;

public class Cat {
    private String name;
    private String color;



    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cat(String name, String color) {
        this.name = name;
        this.color = color;
    }

    @Override
    public String toString() {
        return  "Cats " +
                "name is " + name +
                ", and his color is " + color;
    }
}
