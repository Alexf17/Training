package org.example.TESTING.dryKissYagni;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

class Product {
    private String name;
    private double price;

    public void saveToDatabase() {
        // Сохранение товара в базу данных
    }

    public void generateInvoice() {
        // Генерация счета для товара
    }

    public void sendEmailConfirmation() {
        // Отправка электронного письма с подтверждением
    }
}

class ProductTest {
    @Mock
    Product product = Mockito.mock(Product.class);

    @Test
    void saveToDatabaseTest() {
        product.saveToDatabase();
        Mockito.verify(product).saveToDatabase();
    }

    @Test
    void generateInvoiceTest() {
        product.generateInvoice();
        Mockito.verify(product).generateInvoice();
    }

    @Test
    void sendEmailConfirmationTest() {
        product.sendEmailConfirmation();
        Mockito.verify(product).sendEmailConfirmation();
    }

}


