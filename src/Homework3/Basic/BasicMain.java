package Homework3.Basic;

import java.io.*;
import java.util.Scanner;

public class BasicMain {
    public static void main(String[] args) {

        System.out.println("Задание 1");

        Toyota toyota = new Toyota();
        toyota.turnOnMusic();
        toyota.startMoving();
        toyota.stopMoving();
        toyota.turnOnLights();

        Lada lada = new Lada();
        lada.breakDown();
        lada.startMoving();
        lada.stopMoving();
        lada.turnOnLights();

        System.out.println("\nЗадание 2");

        File directory = new File("resource");
        File file = new File("resource/my_first_file.txt");

        try {
            directory.mkdir();
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringBuilder builder = new StringBuilder();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                builder.append(scanner.nextLine()).append(" ");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(builder);

        System.out.println("\n Задание 3");
        File report = new File("resource/report.txt");
        try {
            report.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FinancialRecord record = new FinancialRecord(500, 300);

        try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(report))) {

            outputStreamWriter.write(String.valueOf(record));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}