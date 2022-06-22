package Homework3.Advanced;

import Homework3.Basic.*;

public class CarFactory {

    public static Lada createLada(){
        return new Lada();
    }

    public static Toyota createToyota(){
        return new Toyota();
    }
}
