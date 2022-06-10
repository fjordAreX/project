import java.util.Arrays;
public class HomeWork1 {
    public static void main(String[] args) {
        // Level 1
        System.out.println("\t\t\tLevel 1:");

        // Exercise 1
        System.out.println("Exercise 1:");

        String hi = "                Hello ";
        String world = " WoRld!";
        char newLine = '\n';
        System.out.println((hi.trim() + world.toLowerCase() + newLine).repeat(3));
        // or
        String hiTrimmed = hi.trim();
        String worldLowerCase = world.toLowerCase();
        String result = hiTrimmed + worldLowerCase + newLine;
        String repeatedResult = result.repeat(3);
        System.out.println(repeatedResult);

        // Exercise 2
        System.out.println("Exercise 2:");

        double height = 1.8;
        double weight = 73.6;
        double bmi = weight / (height * height); //Math.pow(height,2)
        System.out.println(bmi);
        double bmiRounded = Double.parseDouble(String.format("%.1f", bmi).replace(",","."));
        System.out.println(bmiRounded);

        // Exercise 3
        System.out.println("\nExercise 3:");

        char[] arr = {'a', 'b', 'c', 'd', 'e'};
        String firstCopyOfArray = String.valueOf(arr);
        System.out.println(firstCopyOfArray);
        arr[3] = 'h';
        String secondCopyOfArray = String.valueOf(arr);
        System.out.println(secondCopyOfArray);

        //Level 2
        System.out.println("\n\t\t\tLevel 2:");

        // Exercise 1

        System.out.println("Exercise 1:");
        String number = "234";
        String text = "some_text";
        short numberParsed = Short.parseShort(number);
        short textLength = (short) text.length();
        short results = (short) (numberParsed + textLength);
        System.out.println(results);

        //Exercise 2

        System.out.println("\nExercise 2:");
        byte a = 3;
        byte b = 5;
        byte resulted = (byte) Math.pow((a + b), 2);
        System.out.println(resulted);

        //Exercise 3
        System.out.println("\nExercise 3:");

        int[] intArr1 = {1, 2, 5, 7, 10};
        int[] intArr2 = {2, 3, 2, 17, 15};
        int[] answer = new int[intArr1.length * 3];

        System.arraycopy(intArr1, 0, answer, 0, intArr1.length);

        for (int i = intArr1.length, c = 0; i < intArr1.length * 2; c++, i++)
            answer[i] = intArr2[c];

        for (int i = intArr1.length * 2, c = 0; i < answer.length; i++, c++)
            answer[i] = intArr1[c] * intArr2[c];

        System.out.println(Arrays.toString(answer));

        //Exercise 4
        System.out.println("\nExercise 4:");

        String word = "Hello world!";
        String wordUpperCase = word.toUpperCase();
        String wordReplaced = wordUpperCase.replace("L", "R");
        String wordLimited = wordReplaced.substring(0, 8);
        System.out.println(wordLimited);
        // or
        String answ = word.toUpperCase().replace('L', 'R').substring(0, 8);
        System.out.println(answ);




                                                //Level 3
        System.out.println("\n\t\t\tLevel 3:\n");

        String before = "<client>(Какие то данные)<data>79999999999;Иванов Иван;test.A-_3242@gmail.com</data></client>";
        String after = masking(before);
        System.out.println(after);
    }

    public static String masking(String text){
        String info = infoSpace(text);
        String answer;
        if (info.isEmpty()) return text;
        else {
            String[] arrOfInfo = info.split(";");
            for (int i = 0; i< arrOfInfo.length ; i++) {
                try {
                    if (arrOfInfo[i].contains("@")) arrOfInfo[i] = maskEmail(arrOfInfo[i]);
                    else if (arrOfInfo[i].contains("7")) arrOfInfo[i] = maskNumber(arrOfInfo[i]);
                    else arrOfInfo[i] = maskName(arrOfInfo[i]);
                } catch (IllegalStateException ignored){}
            }
            answer = String.join(";",arrOfInfo);
        }
        return text.replace(info,answer);
    }
    private static String infoSpace(String text){
        int openingInfo = text.indexOf("<data>");
        int closingInfo = text.lastIndexOf("</data>");
        String info = text.substring(openingInfo, closingInfo);
        info = info.replace("<data>","");
        return info;
    }
    private static String maskEmail(String mail){
        String emailsSite = mail.substring(mail.lastIndexOf("@"),mail.lastIndexOf("."));
        String maskedEmailsSite = "*".repeat(emailsSite.length()-1);

        return mail.replaceAll("\\w@\\w+", "*@"+maskedEmailsSite);

    }
    private static String maskNumber(String text){
        StringBuilder maskedNum = new StringBuilder(text);

        maskedNum.setCharAt(4, '*');
        maskedNum.setCharAt(5, '*');
        maskedNum.setCharAt(6, '*');

        return maskedNum.toString();
    }

    private static String maskName(String text){
        String [] arr = text.split(" ");

        String surnamesMaskedLetters = "*".repeat(arr[0].length()-2);
        arr[0] = arr[0].replaceAll(arr[0].substring(1,arr[0].length()-1),surnamesMaskedLetters);

        if (arr.length ==3) arr[2] = arr[2].replaceAll(arr[2].substring(1),".");
        return String.join(" ",arr);
    }

    }


