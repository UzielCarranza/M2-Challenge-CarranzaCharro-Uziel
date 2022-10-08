package com.serviceprovider.m2challengecarranza_charrouziel.service;

import com.serviceprovider.m2challengecarranza_charrouziel.data.Month;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class MonthService {

    //    Data
    private List<Month> monthList = new ArrayList<>(Arrays.asList(
            new Month(1, "January"),
            new Month(2, "February"),
            new Month(3, "March"),
            new Month(4, "April"),
            new Month(5, "May"),
            new Month(6, "June"),
            new Month(7, "July"),
            new Month(8, "August"),
            new Month(9, "September"),
            new Month(10, "October"),
            new Month(11, "November"),
            new Month(12, "December")
    ));

    public Month getMonthByNumberService(int monthNumber){
        if (monthNumber < 1 || monthNumber > 12) {
            throw new IllegalArgumentException("Input must be between 1 and 12");
        }
        return monthList.stream().filter(month -> month.getNumber() == monthNumber).findFirst().orElse(null);
    }
}
