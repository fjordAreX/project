package Homework4.Basic;

public class BasicMain {
    public static void main(String[] args) {

        AbleToFly[] flyingObjects =
                {new Plane(10),
                 new Duck(true),
                 new Duck(false),
                 new Plane(-1)};

        for (AbleToFly flyingObject : flyingObjects) {
            try {
                flyingObject.fly();
            } catch (FlyException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
