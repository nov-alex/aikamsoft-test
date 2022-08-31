package test.apiimpl.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.api.dto.request.StatDto;
import test.api.dto.response.StatResponseDto;
import test.api.dto.response.StatsProductsDto;
import test.api.service.StatService;
import test.data.readmodel.ProductsReadModel;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class StatServiceImpl implements StatService {


    private final ProductsReadModel productsReadModel;

    @Override
    public StatResponseDto processStatRequest(StatDto statDto) {

        StatsProductsDto statsProductsDto = productsReadModel.getProductsByDateIntervalDesc(statDto.getStartDate(), statDto.getEndDate());
        StatResponseDto statResponseDto = new StatResponseDto();
        statResponseDto.setCustomers(statsProductsDto.getCustomers());
        statResponseDto.setTotalExpenses(statsProductsDto.getTotalExpenses());
        statResponseDto.setAvgExpenses(statsProductsDto.getAvgExpenses());
        statResponseDto.setTotalDays(StatResponseDto
                .countBusinessDaysBetween(statDto.getStartDate(), statDto.getEndDate()));
        return statResponseDto;
    }
}
