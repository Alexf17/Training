package org.example._2024_02_08_morning.taski;

import org.example.TESTING._2024_02_08_morning.taski.Book;
import org.example.TESTING._2024_02_08_morning.taski.BookRepository;
import org.example.TESTING._2024_02_08_morning.taski.LibraryManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class LibraryManagerTest {
    @InjectMocks
    LibraryManager libraryManager;
    @Mock
    BookRepository bookRepository;
    Book book = Mockito.mock(Book.class);

    private List<Book> bookList = new ArrayList<>();
    @BeforeEach
    private void addBookToList(){
        Book book1 = Mockito.mock(Book.class);
        Book book2 = Mockito.mock(Book.class);
        bookList.add(book);
        bookList.add(book1);
        bookList.add(book2);
    }

    @Test
    void findBookByIdTest() {
        Mockito.when(bookRepository.findById("1")).thenReturn(Optional.of(book));
        Optional<Book> expected = Optional.ofNullable(book);
        Optional<Book> actual = libraryManager.findBookById("1");
        Mockito.verify(bookRepository).findById("1");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findAllBooksTest() {
        Mockito.when(bookRepository.findAll()).thenReturn(bookList);
        List<Book> actual = libraryManager.findAllBooks();
        Assertions.assertEquals(bookList,actual);
        Mockito.verify(bookRepository).findAll();

    }

    @Test
    void addBookTest() {
    }

    @Test
    void deleteBookTest() {
    }

    @Test
    void updateBookTest() {
    }

    @Test
    void findBooksByAuthorTest() {
    }

    @Test
    void findBookByTitleTest() {
    }

    @Test
    void findBooksContainingTitleTest() {
    }

    @Test
    void lendBookTest() {
    }

    @Test
    void returnBookTest() {
    }
}