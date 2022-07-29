package ru.netology.domain;

public class Book extends Product {

    // Поля
    private String author;

    // Конструкторы
    public Book() {

    }

    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }

    // Get/Set
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
