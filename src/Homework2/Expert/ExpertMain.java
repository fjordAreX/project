package Homework2.Expert;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ExpertMain {
    public static void main(String[] args) {

        Map<Integer, Map<String, String[]>> allData = GeneratorExpertHomework.getData();

        Map<Integer, String[]> allInputTrafficData = new HashMap<>();
        Map<Integer, Integer> inputTrafficDataByQuantity = new LinkedHashMap<>();

        //Сортируем полученную информацию
        for (Map.Entry<Integer, Map<String, String[]>> entry : allData.entrySet()) {
            Map<String, String[]> traffic = entry.getValue();

            for (Map.Entry<String, String[]> entryTrafficData : traffic.entrySet()) {

                if (entryTrafficData.getKey().equals("input")) {
                    // Регион и массив всех въехавших номеров
                    allInputTrafficData.put(entry.getKey(), entryTrafficData.getValue());
                    // Регион и количество въехавших машин
                    inputTrafficDataByQuantity.put(entry.getKey(), entryTrafficData.getValue().length);
                }
            }
        }
        // Определяем ТОП-5 в порядке убывания
        Map<Integer, Integer> top5 = inputTrafficDataByQuantity.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).limit(5)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (x, y) -> y, LinkedHashMap::new));

        // Определяем из каких регионов въезжали чаще всего в топ-5
        Map<Integer, Map<String, Integer>> popularIncomingRegions = new HashMap<>();
        // Специальные номера (М---АВ)
        int specialCars = 0;

        for (Map.Entry<Integer, String[]> entry : allInputTrafficData.entrySet()) {

            Map<String, Integer> fromWhereAndHowMany = new HashMap<>();
            int count;

            // Если регион есть в ТОП-5
            if (top5.containsKey(entry.getKey())) {
                Pattern region = Pattern.compile("(\\p{L})\\d{3}(\\p{L}{2})(\\d+)");

                // Проходимся по массиву, определяя регион
                for (String numberPlate : entry.getValue()) {
                    count = 0;
                    specialCars = 0;
                    Matcher matcher = region.matcher(numberPlate);

                    if (matcher.find()) {

                        // Находим все номера в массиве, с таким регионом
                        for (String numberPlate2 : entry.getValue()) {

                            if (numberPlate2.matches("(\\p{L})\\d{3}(\\p{L}{2})" + matcher.group(3))) {
                                count += 1;
                            }
                        }
                        // Добавляем в Map регион и количество машин из этого региона
                        fromWhereAndHowMany.put(matcher.group(3), count);

                        // Проверяем специальные ли номера у номера из массива
                        if (matcher.group(0).matches("М\\d{3}АВ(\\d+)")) {
                            specialCars += 1;
                        }
                    }
                }

                // Определяем один самый популярный номер региона, въезжающего в регион из топ-5
                Map<String, Integer> biggestInput = fromWhereAndHowMany.entrySet().stream()
                        .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(1)
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

                popularIncomingRegions.put(entry.getKey(), biggestInput);
            }
        }

        // Вывод

        // Проходимся по топ-5, чтобы вывод был в порядке убывания
        for (Map.Entry<Integer, Integer> Top5Regions : top5.entrySet()) {

            // Проходимся по Map, который содержит регион из топ-5 и Map, содержащий самый популярный въезжающий номер и кол-во
            for (Map.Entry<Integer, Map<String, Integer>> incomingToTop5 : popularIncomingRegions.entrySet()) {

                // Убеждаемся, что выводим в порядке убывания
                if (Top5Regions.getKey().equals(incomingToTop5.getKey())) {

                    // Получаем самый часто въезжающий номер региона и количество машин, въехавших из этого региона
                for (Map.Entry<String, Integer> theBiggestInputToEachOfTop5 : incomingToTop5.getValue().entrySet()) {

                        System.out.println("В регион " + incomingToTop5.getKey() +
                                " больше всего въехало машин с номерами " + theBiggestInputToEachOfTop5.getKey()
                                + " в количестве " + theBiggestInputToEachOfTop5.getValue() + " машин");
                    }
                }
            }
        }

        System.out.println("Cпециальные машины пересекли границы регионов " + specialCars + " раз");
    }
}
