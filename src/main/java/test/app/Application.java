package test.app;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.api.dto.request.SearchDto;
import test.api.dto.request.StatDto;
import test.api.dto.response.BaseResponseDto;
import test.api.dto.response.ErrorResponseDto;
import test.api.service.SearchService;
import test.api.service.StatService;
import test.exception.RequestException;

import java.io.IOException;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class Application {

    private final Cli cli;
    private final StatService statService;
    private final SearchService searchService;
    private final ObjectMapper mapper;

    void start(String[] args) {
        try {
            cli.parseArg(args);
        } catch (Exception ex) {
            System.out.println("Arg error : " + ex.getMessage());
            return;
        }
        processRequest();
    }

    private void processRequest() {
        BaseResponseDto responseDto;
        try {
            switch (cli.getEndpoint()) {
                case STAT:
                    responseDto = statService.processStatRequest(mapper.readValue(cli.getInputFile(), StatDto.class));
                    break;
                case SEARCH:
                    responseDto = searchService.processSearchRequest(mapper.readValue(cli.getInputFile(), SearchDto.class));
                    break;
                default:
                    throw new RequestException("Endpoint not valid");
            }
            writeDto(responseDto);
        } catch (Exception e) {
            writeDto(new ErrorResponseDto(e.getMessage()));
        }
    }

    private void writeDto(BaseResponseDto dto) {
        try {
            mapper.writeValue(cli.getOutputFile(), dto);
        } catch (IOException ex) {
            System.out.println("Json write/read error: " + ex.getMessage());
        }
    }

}
