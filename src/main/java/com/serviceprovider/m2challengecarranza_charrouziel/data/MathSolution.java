package com.serviceprovider.m2challengecarranza_charrouziel.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MathSolution {

    //    FIELDS
    private int operand1;
    private int operand2;
    private String operation;
    private int answer;

    //    CONSTRUCTOR


    public MathSolution(int operand1, int operand2, String operation, int answer) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operation = operation;
        this.answer = answer;
    }



    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public int getOperand1() {
        return operand1;
    }

    public void setOperand1(int operand1) {
        this.operand1 = operand1;
    }

    public int getOperand2() {
        return operand2;
    }

    public void setOperand2(int operand2) {
        this.operand2 = operand2;
    }

}
