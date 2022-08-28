package test.dataImpl.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import test.SpringTest;
import test.data.entity.Products;
import test.data.repository.ProductsRepository;

import java.util.List;
import java.util.Map;

class ProductsRepositoryImplTest extends SpringTest {

    @Autowired
    ProductsRepository productsRepository;

    @Test
    void givenLastName_thenReturnList() {
        /*List<Object[]> products = */productsRepository.getCustomersIdsByProductName("Хлеб", 3);
    //    Assertions.assertEquals(1, products.size());
    }

}