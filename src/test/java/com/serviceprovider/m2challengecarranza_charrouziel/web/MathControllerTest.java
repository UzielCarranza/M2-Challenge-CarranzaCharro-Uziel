package com.serviceprovider.m2challengecarranza_charrouziel.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.serviceprovider.m2challengecarranza_charrouziel.dto.MathSolutionDTO;
import com.serviceprovider.m2challengecarranza_charrouziel.dto.MathSolutionDTOTesterString;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(MathController.class)
public class MathControllerTest {


    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    private MathSolutionDTO inputDTO;

    @Before
    public void setUp() {
        inputDTO = new MathSolutionDTO();
    }

    @Test
    public void shouldGet201HttpSuccessfulResponseOnAddEndpoint() throws Exception {
//        Arrange
        inputDTO.setOperand1(2);
        inputDTO.setOperand2(3);
        String inputJson = mapper.writeValueAsString(inputDTO);

        mockMvc.perform(
                        post("/add") //ACT
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated()); //ASSERT

    }

    @Test
    public void shouldReturn422StatusCodeIfInputIsNotANumericCharacter() throws Exception {

//        ARRANGE
        MathSolutionDTOTesterString inputDTOTester = new MathSolutionDTOTesterString(1,"one");

        String inputJson = mapper.writeValueAsString(inputDTOTester);

        mockMvc.perform(
                        post("/add") //ACT
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity()); //ASSERT
    }
}