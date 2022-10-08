package com.serviceprovider.m2challengecarranza_charrouziel.web;

import com.serviceprovider.m2challengecarranza_charrouziel.data.MathSolution;
import com.serviceprovider.m2challengecarranza_charrouziel.dto.MathSolutionDTO;
import com.serviceprovider.m2challengecarranza_charrouziel.service.MathService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class MathController {

    private MathService mathService = new MathService();

    public MathController(MathService mathService) {
        this.mathService = mathService;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution doMathOperation(@RequestBody MathSolutionDTO mathSolutionDTOAdd) {
        return mathService.addition(mathSolutionDTOAdd);
    }
}
