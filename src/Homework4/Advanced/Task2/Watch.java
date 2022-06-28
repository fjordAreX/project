package Homework4.Advanced.Task2;

public class Watch implements CanTick {
    private boolean broken;

    public boolean getBroken() {
        return broken;
    }

    public void setBroken(boolean broken) {
        this.broken = broken;
    }

    public Watch(boolean broken) {
        this.broken = broken;
    }

    @Override
    public void tick() throws WatchBrokenError {

        if (broken) {
            throw new WatchBrokenError("Ошибка: часы сломались.");
        } else {
            System.out.println("часы тикают");
        }

    }

}
