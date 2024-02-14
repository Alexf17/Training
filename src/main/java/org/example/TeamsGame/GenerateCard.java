package org.example.TeamsGame;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class GenerateCard {
    private static int resSum = 0;
    static Random random = new Random();

    public static void main(String[] args) {
        String card = generator();
        System.out.println("Num: " + card);
        System.out.println("CVV: " + genCVV());
        System.out.println("Exp: " + getExpirationDate());
        System.out.println(getAllCardInfo());
    }
    public static String getAllCardInfo( ){
        return generator()+" "+getExpirationDate()+" "+genCVV();
    }

    public static String generator() {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            sb.append(random.nextInt(0, 10));
        }
        if (!check(sb.toString())) {
            sb = new StringBuilder(fix(sb.toString()));
        }
        return sb.toString();
    }

    public static String getExpirationDate() {
        long dateNow = System.currentTimeMillis();
        long maxDate = dateNow + ((365L * 1000 * 60 * 60 * 24) * 5);
        long expirationDate = random.nextLong(dateNow, maxDate);

        LocalDate currentDate3 = LocalDate.ofEpochDay(expirationDate / (24 * 60 * 60 * 1000));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yyyy");
        return currentDate3.format(formatter);
    }

    public static String genCVV() {
        StringBuilder sb = new StringBuilder();
        do {
            for (int i = 0; i < 3; i++) {
                sb.append(random.nextInt(0, 10));
            }
        } while (sb.toString().equals("000"));

        return sb.toString();
    }

    private static boolean check(String cardNumber) {
        String[] cards = cardNumber.split("");
        int evenSum = 0;
        int oddSum = 0;
        int arg1 = 0;
        for (int i = 0; i < cards.length; i++) {
            if (i % 2 == 0) {
                arg1 = Integer.parseInt(cards[i]) * 2;
                if (arg1 > 9) {
                    String[] res = String.valueOf(arg1).split("");
                    int num = Integer.parseInt(res[0]) + Integer.parseInt(res[1]);
                    evenSum += num;
                } else {
                    evenSum += arg1;
                }
            } else {
                oddSum += Integer.parseInt(cards[i]);
            }
        }
        resSum = evenSum + oddSum;

        return resSum % 10 == 0;
    }

    public static String fix(String card) {
        String[] sb = card.split("");
        int delta = resSum % 10;
        int firstNum = Integer.parseInt(sb[1]);

        if (firstNum - delta < 0) {
            sb[1] = String.valueOf(firstNum + (10 - (delta % 10)));
        } else {
            sb[1] = String.valueOf(firstNum - delta);
        }
        return String.join("", sb);
    }
}
