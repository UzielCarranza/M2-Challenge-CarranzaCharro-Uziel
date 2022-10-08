package com.serviceprovider.m2challengecarranza_charrouziel.web;


import com.serviceprovider.m2challengecarranza_charrouziel.data.Month;
import com.serviceprovider.m2challengecarranza_charrouziel.service.MonthService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
public class MonthController {

    //    Fields
    private final MonthService monthService;
    private int min = 1;
    private int max = 12;
    private int random_int;

    public MonthController(MonthService monthService) {
        this.monthService = monthService;
    }

    //    GET METHODS
    @GetMapping("/month/{monthNumber}")
    @ResponseStatus(HttpStatus.OK)
    public Month getMonthByNumber(@PathVariable int monthNumber) {
        return monthService.getMonthByNumberService(monthNumber);
    }

    //    get a random month
    @GetMapping("/randomMonth")
    @ResponseStatus(HttpStatus.OK)
    public Month getRandomMonth() {
//        https://www.educative.io/answers/how-to-generate-random-numbers-in-java
        random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
        return monthService.getMonthByNumberService(random_int);
    }

}
