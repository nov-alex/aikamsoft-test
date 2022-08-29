package test.dataImpl.repository;

import com.google.common.collect.ImmutableList;
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
        List<Customers> customers = customersRepository.allByLastName("Петров");
        Assertions.assertEquals(2, customers.size());
    }

    @Test
    void givenCustomersId_thenReturnList() {
        List<Customers> customers = customersRepository.allByIds(ImmutableList.of(1,5));
        Assertions.assertEquals(2, customers.size());
    }

    @Test
    void givenProductNameAndCount_thenReturnList() {
        List<Customers> customers = customersRepository.getCustomersIdsByProductNameAndCount("Хлеб", 3L);
        Assertions.assertEquals(1, customers.size());
    }

}