package Homework4.Basic;

public class Duck implements AbleToFly {

    private boolean isInjured;

    public boolean isInjured() {
        return isInjured;
    }

    public void setInjured(boolean injured) {
        isInjured = injured;
    }

    public Duck(boolean isInjured) {
        this.isInjured = isInjured;
    }

    @Override
    public void fly() throws FlyException {

        if (isInjured) {
            throw new FlyException("Ошибка: утка ранена");
        } else {
            System.out.println("утка летит");
        }
    }
}

