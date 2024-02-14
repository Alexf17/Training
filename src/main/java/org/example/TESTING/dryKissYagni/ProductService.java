package org.example.TESTING.dryKissYagni;


import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

public class ProductService {
    public void addProduct(Product product) {
        // Добавление товара
    }
    
    public void updateProduct(Product product) {
        // Обновление товара
    }
    
    public void deleteProduct(Product product) {
        // Удаление товара
    }
    
    public double calculatePrice(Product product) {
        // Вычисление цены товара
        return 0;
    }
}
class ProductServiceTest{
    @Mock
    ProductService productService = Mockito.mock(ProductService.class);

    @InjectMocks
    Product product;

    @Test
    void addProductTest() {
        productService.addProduct(product);
        Mockito.verify(productService).addProduct(product);
    }

    @Test
    void updateProductTest() {
        productService.updateProduct(product);
        Mockito.verify(productService).updateProduct(product);
    }
    @Test
    void deleteProductTest() {
        productService.deleteProduct(product);
        Mockito.verify(productService).deleteProduct(product);
    }
    @Test
    void calculatePrice(){
        productService.calculatePrice(product);
        Mockito.verify(productService).calculatePrice(product);
    }
}

