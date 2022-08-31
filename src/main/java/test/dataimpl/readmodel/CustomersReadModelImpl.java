package test.dataimpl.readmodel;

import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.data.entity.Customers;
import test.data.readmodel.CustomersReadModel;
import test.data.repository.CustomersRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class CustomersReadModelImpl implements CustomersReadModel {

    @Autowired
    private CustomersRepository customersRepository;

    @Override
    public List<Map<String, Object>> getAllCustomersByLastName(String lastName) {
        return formatCustomersResult(customersRepository
                .getAllCustomersByLastName(lastName));
    }

    @Override
    public List<Map<String, Object>> getCustomersByProductNameAndCount(String productName, Integer minTimes) {
        return formatCustomersResult(customersRepository
                .getCustomersByProductNameAndCount(productName, minTimes));
    }

    @Override
    public List<Map<String, Object>> getCustomersByMinMaxExpenses(Integer min, Integer max) {
        return formatCustomersResult(customersRepository
                .getCustomersByMinMaxExpenses(min, max));
    }

    @Override
    public List<Map<String, Object>> getCustomersByMinExpenses(Integer maxCustomersCount) {
        return formatCustomersResult(customersRepository
                .getCustomersByMinExpenses(maxCustomersCount));
    }

    private List<Map<String, Object>> formatCustomersResult(List<Customers> customers) {
        return customers.stream()
                .reduce(new ArrayList<>(), (list, customer) -> {
                    list.add(ImmutableMap.of("lastName", customer.getLastName(),
                            "firstName", customer.getFirstName()));
                    return list;
                }, (a, b) -> a);
    }
}
