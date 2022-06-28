package Homework4.Advanced.Task1;

public class Rose extends Plant implements CanBloom, CanSmell {
    @Override
    public void bloom() {
        System.out.println("роза: умеет цвести");
    }

    @Override
    public void smell() {
        System.out.println("роза: умеет пахнуть");
    }
}
