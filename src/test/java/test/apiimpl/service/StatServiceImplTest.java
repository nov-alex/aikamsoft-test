package test.apiimpl.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import test.SpringTest;
import test.api.dto.request.StatDto;
import test.api.dto.response.StatResponseDto;
import test.api.service.StatService;

import java.time.LocalDate;

class StatServiceImplTest extends SpringTest {

    @Autowired
    StatService statService;

    @Test
    void givenStatDto_thenResultOk(){
        StatDto statDto = new StatDto();
        statDto.setStartDate(LocalDate.of(2022,4,1));
        statDto.setEndDate(LocalDate.of(2022,4,4));

        StatResponseDto actualDto = statService.processStatRequest(statDto);

        try {
            ObjectMapper mapper = new ObjectMapper();
            System.out.println(mapper.writeValueAsString(actualDto));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}