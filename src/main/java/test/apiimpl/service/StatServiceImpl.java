package test.apiimpl.service;

import org.springframework.stereotype.Component;
import test.api.dto.request.StatDto;
import test.api.dto.response.StatResponseDto;
import test.api.service.StatService;

@Component
public class StatServiceImpl implements StatService {

    @Override
    public StatResponseDto processStatRequest(StatDto statDto) {

        return null;
    }
}
