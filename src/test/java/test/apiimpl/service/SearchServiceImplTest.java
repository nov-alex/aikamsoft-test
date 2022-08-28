package test.apiimpl.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import test.SpringTest;
import test.api.dto.request.SearchDto;
import test.api.dto.request.StatDto;
import test.api.dto.response.BaseResponseDto;
import test.api.dto.response.SearchResponseDto;
import test.apiimpl.factory.provider.SearchByLastNameProvider;
import test.apiimpl.factory.provider.SearchByProductNameProvider;

import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SearchServiceImplTest extends SpringTest {

    @Autowired
    SearchServiceImpl searchService;

    @Test
    void givenSearchRequest_whenRequestValid_thenValidResponse() {
        List<Map<String, Object>> list = ImmutableList.of(
                ImmutableMap.of("lastName", "Иванов"),
                ImmutableMap.of("productName", "Минеральная вода",
                        "minTimes", 5));

        SearchDto searchDto = new SearchDto();
        searchDto.setCriterias(list);

        SearchResponseDto responseDto = new SearchResponseDto();
        responseDto.setResults(
                ImmutableList.of(
                        (ImmutableMap.of("criteria", ImmutableMap.of("lastName", "Иванов"),
                                "results",
                                ImmutableList.of(
                                        ImmutableMap.of("lastName", "Иванов", "firstName", "Иван"),
                                        ImmutableMap.of("lastName", "Петров", "firstName", "Петя")
                                )
                        )),
                        (ImmutableMap.of("criteria", ImmutableMap.of("productName", "Минеральная вода",
                                        "minTimes", 5),
                                "results",
                                ImmutableList.of(
                                        ImmutableMap.of("lastName", "Сидоров", "firstName", "Сидр"),
                                        ImmutableMap.of("lastName", "Машина", "firstName", "Маша")
                                )
                        ))
                )
        );

/*
        when(searchByLastNameProvider.get(anyMap())).thenReturn(
                ImmutableMap.of("criteria", ImmutableMap.of("lastName", "Иванов")),
                ImmutableMap.of("results",
                        ImmutableList.of(
                                ImmutableMap.of("lastName", "Иванов", "firstName", "Иван"),
                                ImmutableMap.of("lastName", "Петров", "firstName", "Петя")
                        )));
        when(searchByProductNameProvider.get(anyMap())).thenReturn(
                ImmutableMap.of("criteria", ImmutableMap.of("productName", "Минеральная вода",
                        "minTimes", 5)),
                ImmutableMap.of("results",
                        ImmutableList.of(
                                ImmutableMap.of("lastName", "Сидоров", "firstName", "Сидр"),
                                ImmutableMap.of("lastName", "Машина", "firstName", "Маша")
                        )));

 */
        SearchResponseDto dto = searchService.processSearchRequest(searchDto);
        Assertions.assertEquals(dto, responseDto);

        String json;
        StatDto statDto;
        try {
            ObjectMapper mapper = new ObjectMapper();
            json = mapper.writeValueAsString(dto);

            mapper.registerModule(new JavaTimeModule());
            mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            String json2 = "{\"startDate\": \"2020-01-14\", \"endDate\": \"2020-01-26\"}";
            statDto = mapper.readValue(json2, StatDto.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}