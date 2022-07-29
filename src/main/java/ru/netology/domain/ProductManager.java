package ru.netology.domain;

import ru.netology.repository.ProductRepository;

public class ProductManager {
    // Поля
    private ProductRepository repo;

    // Конструктор
    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }

    // Методы
    // 1. Добавление Product в репозиторий
    public void add(Product item) {
        repo.save(item);
    }

    // 2. Поиск
    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repo.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }

}
