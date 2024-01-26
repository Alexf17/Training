package org.example._2023._08_12_23;

import java.util.Arrays;

public class Handler {
    /**
     * 1. Вывести все адреса библиотек
     */
    public static void printAllAddresses(Library[] libraries) {
        for (Library library : libraries) {
            System.out.println(library.getAddress());
        }
    }

    /**
     * 2. Подсчитать общее количество книг во всех библиотеках
     */
    public static void printTotalBookCount(Library[] libraries) {
        int bookCount = 0;
        for (Library library : libraries) {
            int count = library.getBooks().length;
            bookCount = bookCount + count;
        }
        System.out.println("ALL BOOKS NUMBER IS: " + bookCount);
    }

    /**
     * 3. Вывести названия всех книг в библиотеке public static void printAllBookNames(Library library)
     */
    public static void printAllBookNames(Library library) {
        Book[] books = library.getBooks();
        for (Book book : books) {
            System.out.println(book.getName());
        }
    }

    /**
     * 4. Найти библиотеки, где есть электронные книги
     */
    public static void printLibrariesWithEBooks(Library[] libraries) {
        for (int i = 0; i < libraries.length; i++) {
            Book[] books = libraries[i].getBooks();
            for (int j = 0; j < books.length; j++) {
                if (books[j].isEBOOK()) {
                    System.out.println("Library at \"" + libraries[i].getAddress() + "\"  has EBOOK");
                    break;
                }
            }
        }
    }

    /**
     * 5. Вывести книги в заданном состоянии
     */
    public static void printBooksByCondition(Library[] libraries, Condition condition) {
        for (Library library : libraries) {
            Book[] books = library.getBooks();
            for (Book book : books) {
                if (book.getCondition() == condition) {
                    System.out.println(book);
                }
            }
        }
    }

    /**
     * 6. Вывести список библиотек с количеством книг больше заданного
     * public static void printLibrariesWithMoreThanXBooks(Library[] libraries, long count)
     */
    public static void printLibrariesWithMoreThanXBooks(Library[] libraries, long count) {
        boolean flag = true;
        for (Library library : libraries) {
            if (library.getBooks().length > count) {
                System.out.println(library);
                flag = false;
            }
        }
        System.out.println(flag ? "There are no libraries with such a number of books" : "");
    }

    /**
     * 7. Вывести книги, изданные до заданного года
     * public static void printBooksIssuedBeforeYear(Library[] libraries, int year)
     */
    public static void printBooksIssuedBeforeYear(Library[] libraries, int year) {
        for (Library library : libraries) {
            Book[] books = library.getBooks();
            for (Book book : books) {
                if (book.getIssueYear() < year) {
                    System.out.println(book);
                }
            }
        }
    }

    /**
     * 8. Вывести авторов книг в алфавитном порядке
     * public static void printAuthorsAlphabetically(Library[] libraries)
     */
    public static void printAuthorsAlphabetically(Library[] libraries) {
        for (Library library : libraries) {
            Book[] books = library.getBooks();
            String[] authors = new String[library.getBooks().length];
            for (int i = 0; i < books.length; i++) {
                authors[i] = books[i].getAuthor();
            }
            Arrays.sort(authors);
            System.out.println("Authors in library at address " + library.getAddress() + ":");
            System.out.println(Arrays.toString(authors));
            System.out.println("--------------------------------------");
        }
    }

    /**
     * 9. Вывести библиотеки, которые не имеют книг
     * public static void printLibrariesWithoutBooks(Library[] libraries)
     */
    public static void printLibrariesWithoutBooks(Library[] libraries) {
        for (Library library : libraries) {
            if (library.getBooks().length == 0) {
                System.out.println("The library at address " + library.getAddress() + " does not contain books");
            }
        }
    }

    /**
     * 10. Вывести книги, названия которых начинаются на заданную букву
     * public static void printBooksStartingWithLetter(Library[] libraries, char letter)
     */
    public static void printBooksStartingWithLetter(Library[] libraries, char letter) {
        for (Library library : libraries) {
            Book[] books = library.getBooks();
            for (Book book : books) {
                if (book.getName().toLowerCase().startsWith(String.valueOf(letter).toLowerCase())) {
                    System.out.println(book.getName());
                }
            }
        }
    }

    /**
     * 11. Вывести библиотеки по убыванию количества книг
     * public static void printLibrariesByDescendingBookCount(Library[] libraries)
     */
    public static void printLibrariesByDescendingBookCount(Library[] libraries) {
        for (int i = 0; i < libraries.length - 1; i++) {
            for (int j = 0; j < libraries.length - i - 1; j++) {
                if (libraries[j].getBookNumbers() < libraries[j + 1].getBookNumbers()) {
                    Library temp = libraries[j];
                    libraries[j] = libraries[j + 1];
                    libraries[j + 1] = temp;
                }
            }
        }
        for (Library library : libraries) {
            System.out.println(library);
        }
    }

    /**
     * 12. Вывести авторов и количество их книг в каждой библиотеке
     */
    public static void printAuthorsAndTheirBookCounts(Library[] libraries) {
        for (Library library : libraries) {
            Book[] books = library.getBooks();
            String[] authors = new String[library.getBooks().length];
            int[] arrOfQuantity = new int[library.getBooks().length];
            for (int i = 0; i < books.length; i++) {
                for (int j = 0; j < authors.length; j++) {
                    authors[i] = books[i].getAuthor();
                    if (authors[i].equals(books[j].getAuthor())) {
                        arrOfQuantity[i] = arrOfQuantity[i] + 1;
                    }
                }
            }
            for (int i = 0; i < authors.length; i++) {
                System.out.println(authors[i] + " happened " + arrOfQuantity[i] + " times");
            }
        }
    }

    /**
     * 13. Вывести наиболее часто встречающееся состояние книг
     */
    public static void printMostCommonBookCondition(Library[] libraries) {
        for (Library library : libraries) {
            int newBook = 0;
            int oldBook = 0;
            int damageBook = 0;
            System.out.print("The library at address " + library.getAddress() + " has more ");
            for (Book book : library.getBooks()) {
                if (book.getCondition() == Condition.NEW) {
                    ++newBook;
                } else if (book.getCondition() == Condition.OLD) {
                    ++oldBook;
                } else ++damageBook;
            }
            String maxBook = (newBook >= oldBook && newBook >= damageBook) ? "NEW" :
                    (oldBook >= newBook && oldBook >= damageBook) ? "OLD" :
                            "DAMAGED";
            System.out.println(maxBook + " books");
        }
    }

    /**
     * 14. Вывести библиотеки, где нет поврежденных книг
     */
    public static void printLibrariesWithoutDamagedBooks(Library[] libraries) {
        for (Library library : libraries) {
            boolean isDamage = false;
            for (Book book : library.getBooks()) {
                if (book.getCondition() == Condition.DAMAGED) {
                    isDamage = true;
                    break;
                }
            }
            if (!isDamage)
                System.out.println("The library at address " + library.getAddress() + " has only good books");
        }
    }

    /**
     * 15. Вывести все уникальные года издания книг
     */
    public static void printUniqueIssueYears(Library[] libraries) {

        StringBuilder years = new StringBuilder();
        for (Library library : libraries) {
            Book[] books = library.getBooks();
            if (books.length == 0) continue;
            for (int i = 0; i < books.length; i++) {
                int year = books[i].getIssueYear();
                years.append(year).append(',');

            }
        }

        String[] yearsArr = years.toString().split(",");
        Arrays.sort(yearsArr);

        int uniqueCount = 0;
        for (int i = 0; i < yearsArr.length; i++) {
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (yearsArr[i].equals(yearsArr[j])) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                uniqueCount++;
            }
        }
        String[] newArray = new String[uniqueCount];
        int newIndex = 0;

        for (int i = 0; i < yearsArr.length; i++) {
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (yearsArr[i].equals(yearsArr[j])) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                newArray[newIndex++] = yearsArr[i];
            }
        }
        System.out.println(Arrays.toString(newArray));

    }

    /**
     * 16. Вывести книги сортированные по году издания в каждой библиотеке
     */
    public static void printBooksSortedByIssueYear(Library[] libraries) {
        for (Library library : libraries) {
            int[] year = new int[library.getBooks().length];
            Book[] books = library.getBooks();
            for (int i = 0; i < books.length; i++) {
                year[i] = books[i].getIssueYear();
            }
            Arrays.sort(year);
            System.out.println(Arrays.toString(year));
        }
    }

    /**
     * 17. Вывести количество библиотек, где есть хотя бы одна электронная книга
     */
    public static void printCountOfLibrariesWithAtLeastOneEBook(Library[] libraries) {
        int count = 0;
        for (int i = 0; i < libraries.length; i++) {
            Book[] books = libraries[i].getBooks();
            for (int j = 0; j < books.length; j++) {
                if (books[j].isEBOOK()) {
                    ++count;
                    break;
                }
            }
        }
        System.out.println("We have " + count + " libraries with EBOOK");
    }

    /**
     * 18. Вывести книги, чьё название содержит определённое слово
     */
    public static void printBooksContainingWord(Library[] libraries, String word) {
        for (Library library : libraries) {
            Book[] books = library.getBooks();
            for (Book book : books) {
                if (book.getName().toLowerCase().contains(word.toLowerCase()))
                    System.out.println(book.getName());
            }
        }
    }

    /**
     * 19. Вывести пары "Автор - Самая старая книга"
     */
    public static void printAuthorsWithOldestBooks(Library[] libraries) {
        for (Library library : libraries) {
            Book[] books = library.getBooks();
            if (books.length == 0) continue;
            int minYear = Integer.MAX_VALUE;
            int index = 0;
            for (int i = 0; i < books.length; i++) {
                if (books[i].getIssueYear() < minYear) {
                    minYear = books[i].getIssueYear();
                    index = i;
                }
            }
            System.out.println("The oldest book in library at " + library.getAddress() + " is " + books[index].getIssueYear() + " by " + books[index].getAuthor());
        }
    }

    /**
     * 20. Вывести библиотеки, в которых каждая книга - электронная
     */
    public static void printLibrariesWithAllEBooks(Library[] libraries) {
        int count = 0;
        for (Library library : libraries) {
            Book[] books = library.getBooks();
            boolean isEBOOK = true;
            if (books.length == 0) {
                ++count;
                continue;
            }
            for (Book book : books) {
                if (!book.isEBOOK()) {
                    isEBOOK = false;
                    ++count;
                    break;
                }
            }
            if (isEBOOK) {
                System.out.println("The library at address " + library.getAddress() + " has only e-books");
            }
        }
        if (count == libraries.length) System.out.println("No library which contain only e-books");
    }
}









