package test.apiimpl.service;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import test.SpringTest;
import test.api.dto.request.SearchDto;
import test.api.dto.response.SearchResponseDto;
import test.api.service.SearchService;

import java.util.List;
import java.util.Map;

class SearchServiceImplTest extends SpringTest {

    @Autowired
    SearchService searchService;

    @Test
    void givenSearchRequest_whenRequestValid_thenValidResponse() {
        List<Map<String, Object>> list = ImmutableList.of(
                ImmutableMap.of("lastName", "Петров"),
                ImmutableMap.of("productName", "Минеральная вода", "minTimes", 2),
                ImmutableMap.of("minExpenses", 100, "maxExpenses", 700),
                ImmutableMap.of("badCustomers", 1));

        SearchDto searchDto = new SearchDto();
        searchDto.setCriterias(list);

        SearchResponseDto expectedDto = new SearchResponseDto();
        expectedDto.setResults(
                ImmutableList.of(
                        (ImmutableMap.of("criteria", ImmutableMap.of("lastName", "Петров"),
                                "results",
                                ImmutableList.of(
                                        ImmutableMap.of("lastName", "Петров", "firstName", "Макс"),
                                        ImmutableMap.of("lastName", "Петров", "firstName", "Андрей")
                                )
                        )),
                        (ImmutableMap.of("criteria", ImmutableMap.of("productName", "Минеральная вода",
                                        "minTimes", 2),
                                "results",
                                ImmutableList.of(
                                        ImmutableMap.of("lastName", "California", "firstName", "Paul"),
                                        ImmutableMap.of("lastName", "Ковальчук", "firstName", "Дуся")
                                )
                        )),
                        (ImmutableMap.of("criteria", ImmutableMap.of("minExpenses", 100, "maxExpenses", 700),
                                "results",
                                ImmutableList.of(
                                        ImmutableMap.of("lastName", "Ковальчук", "firstName", "Дуся"),
                                        ImmutableMap.of("lastName", "Петров", "firstName", "Макс")
                                )
                        )),
                        (ImmutableMap.of("criteria", ImmutableMap.of("badCustomers", 1),
                                "results",
                                ImmutableList.of(
                                        ImmutableMap.of("lastName", "Ковальчук", "firstName", "Дуся")
                                )
                        ))
                )
        );

        SearchResponseDto actualDto = searchService.processSearchRequest(searchDto);
        Assertions.assertEquals(expectedDto, actualDto);


/*

        try {
            ObjectMapper mapper = new ObjectMapper();
            System.out.println(mapper.writeValueAsString(actualDto));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

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
        }*/
    }
}