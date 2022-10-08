package com.serviceprovider.m2challengecarranza_charrouziel.web;

import com.serviceprovider.m2challengecarranza_charrouziel.data.MathSolution;
import com.serviceprovider.m2challengecarranza_charrouziel.dto.MathSolutionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class MathController {


    private MathSolution mathSolution;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution doMathOperationAddition(@RequestBody MathSolutionDTO mathSolutionDTOAdd) {
        mathSolution = new MathSolution(mathSolutionDTOAdd.getOperand1(), mathSolutionDTOAdd.getOperand2(), "add", mathSolutionDTOAdd.add());
        return mathSolution;
    }

    @PostMapping("/subtract")
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution doMathOperationSubtraction(@RequestBody MathSolutionDTO mathSolutionDTOSubtract) {
        mathSolution = new MathSolution(mathSolutionDTOSubtract.getOperand1(), mathSolutionDTOSubtract.getOperand2(), "subtract", mathSolutionDTOSubtract.subtract());
        return mathSolution;
    }

    @PostMapping("/multiply")
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution doMathOperationMultiplication(@RequestBody MathSolutionDTO mathSolutionDTOMultiplication) {
        mathSolution = new MathSolution(mathSolutionDTOMultiplication.getOperand1(), mathSolutionDTOMultiplication.getOperand2(), "multiply", mathSolutionDTOMultiplication.multiply());
        return mathSolution;
    }

    @PostMapping("/divide")
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution doMathOperationDivision(@RequestBody MathSolutionDTO mathSolutionDTODivision) {
        mathSolution = new MathSolution(mathSolutionDTODivision.getOperand1(), mathSolutionDTODivision.getOperand2(), "divide", mathSolutionDTODivision.divide());
        return mathSolution;
    }
}
