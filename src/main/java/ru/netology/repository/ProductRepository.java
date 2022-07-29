package ru.netology.repository;

import ru.netology.domain.Product;

public class ProductRepository {
    // Массив
    private Product[] items = new Product[0];

    // Методы
    // 1. Сохранение Product
    public void save(Product item) {
        Product[] tmp = new Product[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    // 2. Получение всех сохраненных Product
    public Product[] findAll() {
        return items;
    }


    // 3. Удаление по id
    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException(
                    "Element with id: " + id + " not found"
            );
        }
        Product[] tmp = new Product[items.length - 1];
        int copyToIndex = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[copyToIndex] = item;
                copyToIndex++;
            }
        }
        items = tmp;
    }

    // 4. Поиск по id
    public Product findById(int id) {
        for (Product product : items) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

}
