package com.serviceprovider.m2challengecarranza_charrouziel.dto;

public class MathSolutionDTOTesterString {
    //    FIELDS
    private int operand1;
    private String operand2;

    public MathSolutionDTOTesterString() {
    }

    public MathSolutionDTOTesterString(int operand1, String operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    public int getOperand1() {
        return operand1;
    }

    public void setOperand1(int operand1) {
        this.operand1 = operand1;
    }

    public String getOperand2() {
        return operand2;
    }

    public void setOperand2(String operand2) {
        this.operand2 = operand2;
    }
}
