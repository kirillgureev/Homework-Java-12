package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

public class ProductRepositoryTest {
    ProductRepository repo = new ProductRepository();

    Book book1 = new Book(1, "Ежегодный пир погребального братства", 123, "Матьяс Энар");
    Book book2 = new Book(2, "Выбор", 257, "Эдит Ева Эгер");
    Book book3 = new Book(3, "Пес по имени Мани", 279, "Бодо Шефер");
    Book book4 = new Book(4, "Дочь понтифика", 300, "Дарио Фо");
    Book book5 = new Book(5, "Перекрестки", 656, "Джонатан Франзен");
    Smartphone smartphone1 = new Smartphone(6, "Galaxy", 65490, "Samsung");
    Smartphone smartphone2 = new Smartphone(7, "Iphone", 93999, "Apple");
    Smartphone smartphone3 = new Smartphone(8, "Redmi", 37000, "Xiaomi");
    Smartphone smartphone4 = new Smartphone(9, "Honor", 38990, "Huawei");
    Smartphone smartphone5 = new Smartphone(10, "Honor", 54990, "Huawei");

    @Test
    public void removeElementById() {
        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone5);
        repo.save(smartphone4);
        repo.removeById(9);

        Product[] expected = {book1, book2, smartphone5};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void ifElementNotFound() {
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(book4);
        repo.save(book5);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);
        repo.save(smartphone4);
        repo.save(smartphone5);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(11);
        });
    }

}
