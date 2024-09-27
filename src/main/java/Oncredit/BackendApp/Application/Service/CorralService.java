package Oncredit.BackendApp.Application.Service;

import Oncredit.BackendApp.Domain.Model.Corral;
import Oncredit.BackendApp.Infraestructure.Adapter.Request.CorralRequest;
import Oncredit.BackendApp.Infraestructure.Adapter.Response.CorralResponse;
import Oncredit.BackendApp.Infraestructure.Persistence.Repository.CorralRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CorralService {

    @Autowired
    private CorralRepository corralRepository;

    @Autowired
    private ModelMapper modelMapper;

    public CorralResponse createCorral(CorralRequest corralRequest) {
        Corral corral = modelMapper.map(corralRequest, Corral.class);
        Corral savedCorral = corralRepository.save(corral);
        return modelMapper.map(savedCorral, CorralResponse.class);
    }

    public List<CorralResponse> getAllCorrals() {
        List<Corral> corrals = corralRepository.findAll();
        return corrals.stream()
                .map(corral -> modelMapper.map(corral, CorralResponse.class))
                .collect(Collectors.toList());
    }

}
