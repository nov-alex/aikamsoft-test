package test.dataimpl.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import test.SpringTest;
import test.data.readmodel.ProductsReadModel;
import test.data.repository.ProductsRepository;

import java.time.LocalDate;

class ProductsRepositoryImplTest extends SpringTest {

    @Autowired
    ProductsRepository productsRepository;
    @Autowired
    ProductsReadModel  productsReadModel;
    @Test
    void givenStartAndEndDates_thenReturnList() {
        productsReadModel.getProductsByDateIntervalDesc(
                LocalDate.of(2022, 04, 01),
                LocalDate.of(2022, 04, 03)
        );
/*
        List<Object[]> results = productsRepository
                .getProductsByDateIntervalDesc(
                        LocalDate.of(2022, 04, 01),
                        LocalDate.of(2022, 04, 03)
                );
        System.out.println(results);

 */
    }

}