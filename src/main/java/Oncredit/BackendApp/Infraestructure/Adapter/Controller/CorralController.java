package Oncredit.BackendApp.Infraestructure.Adapter.Controller;

import Oncredit.BackendApp.Application.Service.CorralService;
import Oncredit.BackendApp.Infraestructure.Adapter.Request.CorralRequest;
import Oncredit.BackendApp.Infraestructure.Adapter.Response.CorralResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/corrals")
public class CorralController {

    @Autowired
    private CorralService corralService;

    @PostMapping
    public ResponseEntity<CorralResponse> createCorral(@RequestBody @Valid CorralRequest corralRequest) {
        CorralResponse responseDTO = corralService.createCorral(corralRequest);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CorralResponse>> getAllCorrals() {
        List<CorralResponse> responseDTOs = corralService.getAllCorrals();
        return new ResponseEntity<>(responseDTOs, HttpStatus.OK);
    }
}
