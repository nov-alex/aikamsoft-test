package test.dataimpl.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import test.SpringTest;
import test.data.entity.Customers;
import test.data.repository.CustomersRepository;

import java.util.List;

class CustomersRepositoryImplTest extends SpringTest {

    @Autowired
    CustomersRepository customersRepository;

    @Test
    void givenLastName_thenReturnList() {
        List<Customers> customers = customersRepository.getAllCustomersByLastName("Петров");
        Assertions.assertEquals(2, customers.size());
    }
    @Test
    void givenProductNameAndCount_thenReturnList() {
        List<Customers> customers = customersRepository.getCustomersByProductNameAndCount("Хлеб", 3);
        Assertions.assertEquals(1, customers.size());
    }

    @Test
    void givenMinMaxExpenses_thenReturnList() {
        List<Customers> customers = customersRepository.getCustomersByMinMaxExpenses(100, 700);
        Assertions.assertEquals(1, customers.size());
    }

    @Test
    void givenMinExpenses_thenReturnList() {
        List<Customers> customers = customersRepository.getCustomersByMinExpenses(1);
        Assertions.assertEquals(1, customers.size());
    }
}