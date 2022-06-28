package Homework4.Advanced;

import Homework4.Advanced.Task1.*;
import Homework4.Advanced.Task2.*;

public class AdvancedMain {
    public static void main(String[] args) {

        System.out.println("Задание 1");

        Pine pine = new Pine();
        Spruce spruce = new Spruce();
        Rose rose = new Rose();
        Fern fern = new Fern();

        CanBloom[] blooming = {rose, fern};
        for (CanBloom bloomer : blooming) {
            bloomer.bloom();
        }

        HasCones[] cones = {pine, spruce};
        for (HasCones havingCones : cones) {
            havingCones.getCones();
        }

        CanSmell[] smelling = {pine, spruce, rose};
        for (CanSmell smelly : smelling) {
            smelly.smell();
        }

        System.out.println("\n Задание 2");

        Watch watch1 = new Watch(false);
        Watch watch2 = new Watch(true);

        Worker worker1 = new Worker(watch1);
        Worker worker2 = new Worker(watch2);

        Shop shop1 = new Shop(worker1);
        Shop shop2 = new Shop(worker2);

        Shop[] shops = {shop1, shop2};
        Brand brand = new Brand("Gussi", shops);

        for (Shop shop : brand.getShops()) {
            Worker worker = shop.getWorker();
            Watch watch = worker.getWatch();

            try {
                watch.tick();
            } catch (WatchBrokenError e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
