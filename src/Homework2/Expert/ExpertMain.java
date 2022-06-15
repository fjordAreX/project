package Homework2.Expert;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ExpertMain {
    public static void main(String[] args) {

        Map<Integer, Map<String, String[]>> allData = GeneratorExpertHomework.getData();

        Map<Integer, String[]> trafficData = new HashMap<>();
        Map<Integer, Integer> topPopular = new LinkedHashMap<>();

        //Сортируем полученную информацию
        for (Map.Entry<Integer, Map<String, String[]>> entry : allData.entrySet()) {
            Map<String, String[]> traffic = entry.getValue();

            for (Map.Entry<String, String[]> entryTrafficData : traffic.entrySet()) {

                if (entryTrafficData.getKey().equals("input")) {
                    // регион и все въехавшие номера
                    trafficData.put(entry.getKey(), entryTrafficData.getValue());
                    // регион и количество въехавших машин
                    topPopular.put(entry.getKey(), entryTrafficData.getValue().length);
                }
            }
        }
        // определяем ТОП-5
        Map<Integer, Integer> top5 = topPopular.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).limit(5)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (x, y) -> y, LinkedHashMap::new));

        // Определяем из каких регионов въезжали чаще всего
        Map<Integer, Map<String, Integer>> popularIncomingRegions = new HashMap<>();
        // специальные номера
        int specialCars = 0;

        for (Map.Entry<Integer, String[]> entry : trafficData.entrySet()) {

            Map<String, Integer> fromWhereAndHowMany = new HashMap<>();
            int count;

            if (top5.containsKey(entry.getKey())) {
                Pattern region = Pattern.compile("(\\p{L})\\d{3}(\\p{L}{2})(\\d+)");

                for (String numberPlate : entry.getValue()) {
                    count = 0;
                    specialCars = 0;
                    Matcher matcher = region.matcher(numberPlate);

                    if (matcher.find()) {

                        for (String numberPlate2 : entry.getValue()) {

                            if (numberPlate2.matches("(\\p{L})\\d{3}(\\p{L}{2})" + matcher.group(3))) {
                                count += 1;
                            }
                        }
                        fromWhereAndHowMany.put(matcher.group(3), count);

                        // специальные номера
                        if (matcher.group(1).equals("М") && matcher.group(2).equals("АВ")) {
                            specialCars += 1;
                            System.out.println(specialCars);
                        }
                    }
                }

                // самый популярный номер, въезжающий в регион
                Map<String, Integer> biggestInput = fromWhereAndHowMany.entrySet().stream()
                        .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(1)
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

                popularIncomingRegions.put(entry.getKey(), biggestInput);
            }
        }

        // вывод
        for (Map.Entry<Integer, Integer> entry0 : top5.entrySet()) {

            for (Map.Entry<Integer, Map<String, Integer>> entry : popularIncomingRegions.entrySet()) {

                if (entry0.getKey().equals(entry.getKey())) {

                for (Map.Entry<String, Integer> entry1 : entry.getValue().entrySet()) {

                        System.out.println("В регион " + entry0.getKey() +
                                " больше всего въехало машин с номерами " + entry1.getKey()
                                + " в количестве " + entry1.getValue() + " машин");
                    }
                }
            }
        }
        System.out.println("Cпециальные машины пересекли границы регионов " + specialCars + " раз");
    }
}
