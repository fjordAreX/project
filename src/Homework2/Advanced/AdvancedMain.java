package Homework2.Advanced;

import java.util.Arrays;

public class AdvancedMain {
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

            if (hasMotorProblem) {
                bill += 10000;
                problemCount += 1;
            }
            if (hasElectricsProblem) {
                bill += 5000;
                problemCount += 1;
            }
            if (hasTransmissionProblem) {
                bill += 4000;
                problemCount += 1;
            }
            if (hasWheelsProblem){
                bill += 2000;
                problemCount += 1;
            }
            if (hasTransmissionProblem && (hasElectricsProblem || hasMotorProblem)){
                bill -= bill*20/100;
            }else if (problemCount ==2){
                bill -= bill*10/100;
            }

            System.out.println("Общий счет: "+ bill +" рублей");
        }

        System.out.println("\nЗадание 4");

        Warehouse warehouse = new Warehouse("Метро Бульвар Рокоссовского",12);
        Worker worker1 = new Worker("Илья",warehouse);
        Worker worker2 = new Worker("Гена",warehouse);

        System.out.println(warehouse);
        worker1.damageProducts(7);
        worker2.damageProducts(5);
        System.out.println(warehouse);


    }
}
