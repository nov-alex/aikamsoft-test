package test.api.dto.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class SearchDtoTest {

    @Test
    void givenJsonString_thenDeserialization() {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        list.add(new HashMap<String, Object>() {
            {
                put("lastName", "Иванов");
            }
        });
        list.add(new HashMap<String, Object>() {
            {
                put("productName", "Минеральная вода");
                put("minTimes", 5);
            }
        });
        SearchDto searchDto = new SearchDto();
        searchDto.setCriterias(list);

        String json = "{" +
                "\"criterias\": [ \n" +
                "{\"lastName\": \"Иванов\"}," +
                "{\"productName\": \"Минеральная вода\", \"minTimes\": 5 }" +
                "]}";

        ObjectMapper mapper = new ObjectMapper();
        Assertions.assertDoesNotThrow(() ->
                Assertions.assertEquals(mapper.readValue(json, SearchDto.class), searchDto));
    }
}