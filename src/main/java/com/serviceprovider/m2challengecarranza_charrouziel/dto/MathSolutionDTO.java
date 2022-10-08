package com.serviceprovider.m2challengecarranza_charrouziel.dto;

public class MathSolutionDTO {

    //    FIELDS
    private int operand1;
    private int operand2;

    public MathSolutionDTO() {
    }

    public MathSolutionDTO(int operand1, int operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    public int add() {
        return operand1 + operand2;
    }

    public int subtract() {
        return operand1 - operand2;
    }

    public int multiply() {
        return operand1 * operand2;
    }

    public int divide() {
        return operand1 / operand2;
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
