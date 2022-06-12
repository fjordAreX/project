package Homework2;

import java.util.Arrays;

public class Advanced {
    public static void main(String[] args) {

        System.out.println("Задание 1");

        double increment = 0.01123;
        double result = 0;
        int count=0;

        if (increment>0) {
            while (result < 1_000_000) {
                result += increment;
                count += 1;
            }
            System.out.println("Количество итераций = " + count);
        }

        System.out.println("\nЗадание 2");

        int [] arr= new int[10];
        Arrays.fill(arr, 1);

        for (int i = 0; i <arr.length ; i++) {
            if(i%2==0){
                arr[i]=0;
            }
        }
        System.out.println(Arrays.toString(arr));

        System.out.println("\nЗадание 3");

        boolean hasFuel = false;
        boolean hasElectricsProblem = true;
        boolean hasMotorProblem = false;
        boolean hasTransmissionProblem = true;
        boolean hasWheelsProblem = false;
        int problemCount =0;
        int bill = 0;

        if (!(hasFuel) && !(hasElectricsProblem) && !(hasWheelsProblem)
                && !(hasMotorProblem) && !(hasTransmissionProblem)) {
            System.out.println("Общий счет: 1000 рублей за консультацию");
        } else {
            bill +=1000; // за консультацию

            if (hasMotorProblem) {
                bill += 10000;
                count += 1;
            }
            if (hasElectricsProblem) {
                bill += 5000;
                count += 1;
            }
            if (hasTransmissionProblem) {
                bill += 4000;
                count += 1;
            }
            if (hasWheelsProblem){
                bill += 2000;
                count += 1;
            }
            if (hasTransmissionProblem && (hasElectricsProblem || hasMotorProblem)){
                bill -= bill*20/100;
            }else if (count ==2){
                bill -= bill*10/100;
            }

            System.out.println("Общий счет: "+ bill);
        }


        System.out.println("\nЗадание 4");

        Warehouse warehouse = new Warehouse("Метро Бульвар Рокоссовского",1000);

        Worker worker1 = new Worker("Ivan");
        Worker worker2 = new Worker("Ilya");
        Worker worker3 = new Worker("Kamil");

        worker1.damageProduct(warehouse);
        System.out.println("Количество оставшейся водки на складе: "+warehouse.getQuantity());
        System.out.println("Количество испорченной продукции первым работником: "+worker1.getAmountOfDamagedProduct());

    }
}

class Warehouse{

    private String address;
    private int quantity;

    public Warehouse(String address,int quantity) {
        this.address = address;
        this.quantity = quantity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }



}

class Worker{
    private String name;
    private int amountOfDamagedProduct;

    public Worker(String name) {
        this.name = name;
        this.amountOfDamagedProduct = 0;
    }

    public String getName() {
        return name;
    }

    public int getAmountOfDamagedProduct() {
        return amountOfDamagedProduct;
    }

    public void setAmountOfDamagedProduct(int amountOfDamagedProduct) {
        this.amountOfDamagedProduct = amountOfDamagedProduct;
    }

    public void damageProduct(Warehouse warehouse){
        setAmountOfDamagedProduct(getAmountOfDamagedProduct()+1);
        warehouse.setQuantity(warehouse.getQuantity()-1);
        System.out.println("Ура я испортил водку!");
    }

}