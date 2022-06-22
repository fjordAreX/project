package Homework3.Expert;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ExpertMain {
    public static void main(String[] args) {

        System.out.println("Задание 1");

        for (int i = 1; i <= 12; i++) {
            profitByMonth(i);
        }

        System.out.println("\nЗадание 2");

        Map<String, Float> map = new LinkedHashMap<>();
        map.put("pyterochka", 0F);
        map.put("okey", 0F);
        map.put("perekrestok", 0F);
        map.put("ydoma", 0F);

        allTimeExpenses(0, map);

        for (Map.Entry<String, Float> entry : map.entrySet()) {
            System.out.println("Расходы " + entry.getKey() + " за весь период: " + entry.getValue());
        }
    }

    public static void profitByMonth(int month) {
        if (month >= 1 && month <= 12) {
            File file = new File("resource/report_" + month + "_2012.txt");
            if (month < 10) {
                file = new File("resource/report_" + "0" + month + "_2012.txt");
            }

            try (Scanner scanner = new Scanner(file)) {
                float sum = 0;
                while (scanner.hasNext()) {
                    String[] arr = scanner.nextLine().split(";");
                    if (arr[0].equals("pyterochka")) {
                        sum += Float.parseFloat(arr[1]) - Float.parseFloat(arr[2]);
                    }
                }

                System.out.println(month + ".2012: " + sum);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void allTimeExpenses(int month, Map<String, Float> map) {
        month += 1;
        if (month >= 1 && month <= 12) {
            File file = new File("resource/report_" + month + "_2012.txt");
            if (month < 10) {
                file = new File("resource/report_" + "0" + month + "_2012.txt");
            }

            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNext()) {
                    String[] arr = scanner.nextLine().split(";");
                    if (arr[0].equals("магазин")) {
                        continue;
                    }
                    float sum = map.get(arr[0]);
                    sum += Float.parseFloat(arr[2]);
                    map.put(arr[0], sum);
                }

                allTimeExpenses(month, map);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

