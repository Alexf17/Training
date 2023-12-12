package org.example._08_12_23;

import com.github.javafaker.Faker;
import lombok.experimental.UtilityClass;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@UtilityClass
public class Generator {
    private static final Faker FAKER = new Faker();
    private static final Random RANDOM = new Random();

    private static Condition randomConditionGen() {
        Condition[] conditions = Condition.values(); //new old damaged
        int index = RANDOM.nextInt(3);
        return conditions[index];
    }

    private static boolean isEbookRandomGen() {
        boolean[] isEbook = {true, false};
        int index = RANDOM.nextInt(2);
        return isEbook[index];
    }

    public static Book[] bookGenerator(int bookNumbers) {
        Book[] books = new Book[bookNumbers];
        for (int i = 0; i < bookNumbers; i++) {
            books[i] = new Book(FAKER.book().author(),
                    FAKER.book().title(),
                    bookIssueDate(),
                    randomConditionGen(),
                    isEbookRandomGen());
        }
        return books;
    }

    private static int bookIssueDate() {
        //        int randomNumber = RANDOM.nextInt(123) + 1900;
        return ThreadLocalRandom.current().nextInt(1900, 2023);

    }

    public static Library[] libraryGen() {
        Random rand = new Random();
        Library[] libraries = new Library[5];
//        int bookNumber =rand.nextInt(25);
        for (int i = 0; i < libraries.length; i++) {
            int bookNumber =rand.nextInt(25);
           libraries[i] = new Library(FAKER.address().streetAddress(),bookNumber,bookGenerator(bookNumber));
        }
        return libraries;
    }
}