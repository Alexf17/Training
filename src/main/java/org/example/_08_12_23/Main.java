package org.example._08_12_23;

import java.util.Arrays;



public class Main {

    private static final Library[] LIBRARIES = Generator.libraryGen();

    public static void main(String[] args) {


//        Handler.printAllAddresses(LIBRARIES);
//        Handler.printTotalBookCount(LIBRARIES);
//        Handler.printAllBookNames(LIBRARIES[0]);
//        Handler.printLibrariesWithEBooks(LIBRARIES);
//        Handler.printBooksByCondition(LIBRARIES,Condition.NEW);
//        Handler.printLibrariesWithMoreThanXBooks(LIBRARIES,20);
//        Handler.printBooksIssuedBeforeYear(LIBRARIES,2020);
//        Handler.printAuthorsAlphabetically(LIBRARIES);
//        Handler.printLibrariesWithoutBooks(LIBRARIES);
//        Handler.printBooksStartingWithLetter(LIBRARIES, 'a');
//        Handler.printLibrariesByDescendingBookCount(LIBRARIES);

//         ***TO DO***
//        Handler.printAuthorsAndTheirBookCounts(LIBRARIES); --

//        Handler.printMostCommonBookCondition(LIBRARIES);
//        Handler.printLibrariesWithoutDamagedBooks(LIBRARIES);

//         ***TO DO***
        Handler.printUniqueIssueYears(LIBRARIES);

//        Handler.printBooksSortedByIssueYear(LIBRARIES);
//        Handler.printCountOfLibrariesWithAtLeastOneEBook(LIBRARIES);
//        Handler.printBooksContainingWord(LIBRARIES,"art");
//        Handler.printAuthorsWithOldestBooks(LIBRARIES);
//        Handler.printLibrariesWithAllEBooks(LIBRARIES);
    }

}
