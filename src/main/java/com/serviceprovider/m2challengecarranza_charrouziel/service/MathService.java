package com.serviceprovider.m2challengecarranza_charrouziel.service;

import com.serviceprovider.m2challengecarranza_charrouziel.data.MathSolution;
import com.serviceprovider.m2challengecarranza_charrouziel.dto.MathSolutionDTO;
import org.springframework.stereotype.Service;

@Service
public class MathService {

    MathSolution mathSolution;

    public MathSolution addition(MathSolutionDTO mathSolutionDTO) {
        mathSolution = new MathSolution(mathSolutionDTO.getOperand1(), mathSolutionDTO.getOperand2(), "add", mathSolutionDTO.add());
        return mathSolution;
    }
}