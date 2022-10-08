package com.serviceprovider.m2challengecarranza_charrouziel.data;

import java.util.Objects;

public class Month {
    //    FIELDS
    private int number;
    private String name;

//    CONSTRUCTOR


    public Month() {
    }

    public Month(int number, String name) {
        this.number = number;
        this.name = name;
    }


//    GETTERS AND SETTERS

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    OVERRIDE METHODS

    @Override
    public String toString() {
        return "Month{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Month month = (Month) o;
        return number == month.number && Objects.equals(name, month.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name);
    }
}
