package com.serviceprovider.m2challengecarranza_charrouziel.web;

import com.serviceprovider.m2challengecarranza_charrouziel.data.MathSolution;
import com.serviceprovider.m2challengecarranza_charrouziel.dto.MathSolutionDTO;
import com.serviceprovider.m2challengecarranza_charrouziel.service.MathService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class MathController {

    private final MathService mathService;

    public MathController(MathService mathService) {
        this.mathService = mathService;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution doMathOperationAddition(@RequestBody MathSolutionDTO mathSolutionDTOAdd) {
        return mathService.addition(mathSolutionDTOAdd);
    }

    @PostMapping("/subtract")
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution doMathOperationSubtraction(@RequestBody MathSolutionDTO mathSolutionDTOSubtract) {
        return mathService.subtraction(mathSolutionDTOSubtract);
    }

    @PostMapping("/multiply")
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution doMathOperationMultiplication(@RequestBody MathSolutionDTO mathSolutionDTOMultiplication) {
        return mathService.multiplication(mathSolutionDTOMultiplication);
    }

    @PostMapping("/divide")
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution doMathOperationDivision(@RequestBody MathSolutionDTO mathSolutionDTODivision) {
        return mathService.division(mathSolutionDTODivision);
    }
}
