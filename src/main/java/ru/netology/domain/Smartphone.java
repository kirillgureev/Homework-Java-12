package ru.netology.domain;

public class Smartphone extends Product {
    // Поля
    private String manufacturer;

    // Конструкторы
    public Smartphone() {

    }

    public Smartphone(int id, String name, int price, String manufacturer) {
        super(id, name, price);
        this.manufacturer = manufacturer;
    }

    // Get/Set
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
