package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
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
    public void addAndSaveAllProducts() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(book5);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);
        manager.add(smartphone5);


        Product[] expected = {book1, book2, book3, book4, book5, smartphone1, smartphone2, smartphone3, smartphone4, smartphone5};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void removeProductsById() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);
        repository.removeById(6);

        Product[] expected = {book1, book2, smartphone2};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByBookName() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] expected = {book1};
        Product[] actual = manager.searchBy("Ежегодный пир погребального братства");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBySmartphoneName() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] expected = {smartphone1};
        Product[] actual = manager.searchBy("Galaxy");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBySmartphoneName2() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);
        manager.add(smartphone5);

        Product[] expected = {smartphone4, smartphone5};
        Product[] actual = manager.searchBy("Honor");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchIfNotProduct() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Nokia");

        Assertions.assertArrayEquals(expected, actual);
    }

}
