package com.serviceprovider.m2challengecarranza_charrouziel.web;


import com.serviceprovider.m2challengecarranza_charrouziel.data.Month;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class MonthController {

    //    MONTH CONVERTER ENDPOINTS

    //    Data
    List<Month> monthList = new ArrayList<>(Arrays.asList(
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

    //    GET METHODS
//    Looks for a month by number
    @GetMapping("/month/{monthNumber}")
    @ResponseStatus(HttpStatus.OK)
    public Month getMonthByNumber(@PathVariable int monthNumber) {
        if (monthNumber < 1 || monthNumber > 12) {
            throw new IllegalArgumentException("Input must be between 1 and 12");
        }
        return monthList.stream().filter(month -> month.getNumber() == monthNumber).findFirst().orElse(null);
    }

}
