package test.data.readmodel;

import test.api.dto.response.StatsProductsDto;

import java.time.LocalDate;

public interface ProductsReadModel {

    StatsProductsDto getProductsByDateIntervalDesc(LocalDate startDate, LocalDate endDate);
}
