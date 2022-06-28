package Homework4.Advanced.Task2;

public class Shop {
    private Worker worker;

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Shop(Worker worker) {
        this.worker = worker;
    }
}
