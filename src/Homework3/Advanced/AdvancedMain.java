package Homework3.Advanced;

import Homework3.Basic.*;

import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdvancedMain {
    public static void main(String[] args) {

        System.out.println("Задание 1");

        Car[] cars = new Car[40];

        for (int i = 0; i < 40; i++) {
            if (i % 2 == 0) {
                cars[i] = CarFactory.createLada();
            } else {
                cars[i] = CarFactory.createToyota();
            }
        }

        for (Car car : cars) {
            if (car instanceof Lada) {
                ((Lada) car).breakDown();
            } else if (car instanceof Toyota) {
                ((Toyota) car).turnOnMusic();
            }
        }

        System.out.println("\nЗадание 2");

        File file = new File("resource/report.txt");
        try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file))) {
            file.delete();
            file.createNewFile();

            Random random = new Random(1);
            for (int i = 0; i < 10; i++) {
                outputStreamWriter.write(String.valueOf(new FinancialRecord(Math.abs(random.nextInt()), Math.abs(random.nextInt())))+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(Scanner scanner = new Scanner(file)) {
            long income = 0;
            long outcome = 0;

            while (scanner.hasNext()) {
                String text = scanner.nextLine();
                String[] arrayOfReports = text.split(";");

                for (String report : arrayOfReports) {
                    Pattern pattern = Pattern.compile("\\p{L}+ = (\\d+), \\p{L}+ = (\\d+)");
                    Matcher matcher = pattern.matcher(report);

                    if (matcher.find()) {
                        income += Long.parseLong(matcher.group(1));
                        outcome += Long.parseLong(matcher.group(2));
                    }
                }
            }
            System.out.println("Общие доходы - " + income + " Общие расходы - " + outcome);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}