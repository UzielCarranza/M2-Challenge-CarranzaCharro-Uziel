package com.serviceprovider.m2challengecarranza_charrouziel.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.serviceprovider.m2challengecarranza_charrouziel.data.Month;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(MonthController.class)
public class MonthControllerTest {

    //TEST FOR MONTH CONTROLLER
    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();


    //    starts tests for ENDPOINT GET MONTH BY NUMBER
    //     @GetMapping("/month/{monthNumber}")

    @Test
    public void shouldReturnMonthBasedOnNumberIdentifier() throws Exception {
//        Arrange
        Month expectedMonth = new Month(3, "March");

        String outputJson = mapper.writeValueAsString(expectedMonth);
        int inputMonth = 3;

        mockMvc.perform(get("/month/{monthNumber}", inputMonth)       // Act
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldGet200HttpResponseOnGetByMonthByNumber() throws Exception {
        // Arrange
        int inputMonth = 1;
        mockMvc.perform(get("/month/{monthNumber}", inputMonth)       // Act
                )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturn422StatusCodeIfNumberIsOutOfRange() throws Exception {
        // Arrange
        int inputMonth = 13;
        mockMvc.perform(get("/month/{monthNumber}", inputMonth)       // Act
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldNotReceiveAnEmptyResponseOnGetMonthByNumber() throws Exception {
        // Arrange
//        https://www.educative.io/answers/how-to-generate-random-numbers-in-java
        int random_int = (int) Math.floor(Math.random() * (12 - 1 + 1) + 1);
        mockMvc.perform(get("/month/{monthNumber}", random_int)       // Act
                )
                .andDo(print())
                .andExpect(jsonPath("$.number").isNotEmpty())
                .andExpect(jsonPath("$.name").isNotEmpty());
    }
//    END OF TESTING ENDPOINT @GetMapping("/month/{monthNumber}")


    //    STARTS TEST CASES FOR ENDPOINT @GetMapping("/randomMonth")
    @Test
    public void shouldGet200HttpResponseOnGetRandomMonth() throws Exception {
        mockMvc.perform(get("/randomMonth")       // Act
                )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldNotReceiveAnEmptyResponse() throws Exception {
        mockMvc.perform(get("/randomMonth")       // Act
                )
                .andDo(print())
                .andExpect(jsonPath("$.number").isNotEmpty())
                .andExpect(jsonPath("$.name").isNotEmpty());
    }


}