package com.ayman.nindemo.service;

import com.ayman.nindemo.model.dto.request.UpdateNinRequest;
import com.ayman.nindemo.model.dto.response.NinResponse;
import com.ayman.nindemo.model.entity.NIN;
import com.ayman.nindemo.repository.NinRepository;
import com.ayman.nindemo.validation.validator.NinValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class NinService {
    private final NinRepository ninRepository;

    public void addMultipleNins(List<String> nins) {
        for (String nin : nins) {
            if (validateNin(nin)) {
                NIN validNIN = new NIN(null, nin);
                ninRepository.save(validNIN);
                log.info("Nin: {} added to the database", validNIN);
            }
        }
    }

    public List<NinResponse> getAll() {
        log.info("Retrieved all nins");
        return toNinResponse(ninRepository.findAll());
    }

    public NIN getById(Long ninId) {
        NIN nin = getNinOrThrow(ninId);
        log.info("Retrieved the nin with the id: {}", ninId);
        return nin;
    }

    public void updateNin(UpdateNinRequest updateNinRequest) {
        NIN NIN1 = getNinOrThrow(updateNinRequest.getNinId());

        NIN1.setNin(updateNinRequest.getNin());
        ninRepository.save(NIN1);
        log.info("Nin with the id: {} updated to: {}", updateNinRequest.getNinId(), updateNinRequest.getNin());

    }

    public void deleteNin(Long ninId) {
        NIN NIN1 = getNinOrThrow(ninId);
        ninRepository.delete(NIN1);
        log.info("Nin with the id: {} deleted", ninId);
    }

    private NIN getNinOrThrow(Long ninId) {
        return ninRepository.findNinById(ninId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "No nin exists with the id: " + ninId
                ));
    }

    private List<NinResponse> toNinResponse(List<NIN> NINS){
        List<NinResponse> ninResponses = new ArrayList<>();
        for(NIN nin : NINS) ninResponses.add(new NinResponse(nin.getId(), nin.getNin()));
        return ninResponses;
    }

    public boolean validateNin(String nin){
        return (nin.length() == 10
                && ((nin.charAt(0) == '1') || (nin.charAt(0) == '2'))
                && (!ninRepository.findNinByNin(nin).isPresent())
        );
    }
}
