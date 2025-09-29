package leetcode;

import lombok.Builder;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookExcersize {

    @Test
    public void test1() {

        Book book1 = new Book("Война и мир", "Лев Толстой");
        Book book2 = new Book("1984", "Джордж Оруэлл");
        Book book3 = new Book("Психология влияния", "Роберт Чалдини");
        Book book4 = new Book("Гордость и предубеждение", "Джейн Остин");
        Book book5 = new Book("Сто лет одиночества", "Габриэль Гарсиа Маркес");

        // Создаем читателей
        List<Book> booksIvan = new ArrayList<>();
        booksIvan.add(book1);
        booksIvan.add(book2);

        Reader ivan = new Reader("Иван Иванов", LocalDate.of(1995, 6, 12), booksIvan);

        List<Book> booksMaria = new ArrayList<>();
        booksMaria.add(book3);
        booksMaria.add(book4);
        Reader maria = new Reader("Мария Петрова", LocalDate.of(1992, 3, 25), booksMaria);
        List<Book> booksPetr = new ArrayList<>();
        booksPetr.add(book5);
        booksPetr.add(book1);
        booksPetr.add(book2);
        Reader petr = new Reader("Петр Сидоров", LocalDate.of(1990, 1, 1), booksPetr);

        List<Book> booksEkaterina = new ArrayList<>();
        booksEkaterina.add(book3);
        booksEkaterina.add(book4);
        booksEkaterina.add(book5);
        Reader ekaterina = new Reader("Екатерина Михайлова", LocalDate.of(1997, 8, 15), booksEkaterina);

        List<Book> booksAleksey = new ArrayList<>();
        booksAleksey.add(book2);
        booksAleksey.add(book1);
        Reader aleksey = new Reader("Алексей Николаев", LocalDate.of(1993, 2, 20), booksAleksey);

        // Создаем коллекцию читателей
        List<Reader> readers = new ArrayList<>();
        readers.add(ivan);
        readers.add(maria);
        readers.add(petr);
        readers.add(ekaterina);
        readers.add(aleksey);

        // Создаем карту Book -> Reader
        Map<Book, Reader> bookToReaderMap = readers.stream()
                .flatMap(reader -> reader.books.stream().map(book -> Map.entry(book, reader)))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        // Выводим карту
        bookToReaderMap.forEach((book, reader) -> System.out.println("Книга: " + book.name + ", Читатель: " + reader.name));
    }

    class Book {
        String name;
        String author;

    public Book(String name, String author) {
            this.name = name;
            this.author = author;
        }
    }

    class Reader {
        String name;
        LocalDate birthDate;
        List<Book> books;

        public Reader(String name, LocalDate birthDate, List<Book> books) {
            this.name = name;
            this.birthDate = birthDate;
            this.books = books;
        }
    }
}
