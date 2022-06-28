package Homework4.Basic;

public class Plane implements AbleToFly {
    private int passengers;

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public Plane(int passengers) {
        this.passengers = passengers;
    }

    @Override
    public void fly() throws FlyException {
        if (passengers < 0) {
            throw new FlyException("Ошибка: пассажиров в самолете меньше 0");
        } else {
            System.out.println("самолет летит");
        }
    }
}
