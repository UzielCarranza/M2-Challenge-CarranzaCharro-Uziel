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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

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
    private MathSolutionDTOTesterString inputDTOTester;

    @Before
    public void setUp() {
        inputDTO = new MathSolutionDTO();
    }

    //    test cases for endpoint  @PostMapping("/add")
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
         inputDTOTester = new MathSolutionDTOTesterString(1, "one");

        String inputJson = mapper.writeValueAsString(inputDTOTester);

        mockMvc.perform(
                        post("/add") //ACT
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity()); //ASSERT
    }


    //    test cases for endpoint  @PostMapping("/subtract")
    @Test
    public void shouldGet201HttpSuccessfulResponseOnSubtractEndpoint() throws Exception {
//        Arrange
        inputDTO.setOperand1(2);
        inputDTO.setOperand2(3);
        String inputJson = mapper.writeValueAsString(inputDTO);

        mockMvc.perform(
                        post("/subtract") //ACT
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated()); //ASSERT

    }

    @Test
    public void shouldReturn422StatusCodeIfInputIsNotANumericCharacterForSubtractEndpoint() throws Exception {

//        ARRANGE
        inputDTOTester = new MathSolutionDTOTesterString(1, "three");

        String inputJson = mapper.writeValueAsString(inputDTOTester);

        mockMvc.perform(
                        post("/subtract") //ACT
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity()); //ASSERT
    }

    //    test cases for endpoint  @PostMapping("/multiply")
    @Test
    public void shouldGet201HttpSuccessfulResponseOnMultiplyEndpoint() throws Exception {
//        Arrange
        inputDTO.setOperand1(2);
        inputDTO.setOperand2(3);
        String inputJson = mapper.writeValueAsString(inputDTO);

        mockMvc.perform(
                        post("/multiply") //ACT
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated()); //ASSERT

    }

    @Test
    public void shouldReturn422StatusCodeIfInputIsNotANumericCharacterForMultiplyEndpoint() throws Exception {

//        ARRANGE
         inputDTOTester = new MathSolutionDTOTesterString(1, "three");

        String inputJson = mapper.writeValueAsString(inputDTOTester);

        mockMvc.perform(
                        post("/multiply") //ACT
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity()); //ASSERT
    }


    //    test cases for endpoint  @PostMapping("/divide")
    @Test
    public void shouldGet201HttpSuccessfulResponseOnDivideEndpoint() throws Exception {
//        Arrange
        inputDTO.setOperand1(2);
        inputDTO.setOperand2(3);
        String inputJson = mapper.writeValueAsString(inputDTO);

        mockMvc.perform(
                        post("/divide") //ACT
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated()); //ASSERT

    }

    @Test
    public void shouldReturn422StatusCodeIfInputIsNotANumericCharacterForDivideEndpoint() throws Exception {

//        ARRANGE
         inputDTOTester = new MathSolutionDTOTesterString(1, "cuatro");

        String inputJson = mapper.writeValueAsString(inputDTOTester);

        mockMvc.perform(
                        post("/divide") //ACT
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity()); //ASSERT
    }

    @Test
    public void shouldReturn422StatusCodeIfSecondOperandIsEqualToZeroForDivideEndpoint() throws Exception {

//        ARRANGE
        inputDTO.setOperand1(1);
        inputDTO.setOperand2(0);

        String inputJson = mapper.writeValueAsString(inputDTO);

        mockMvc.perform(
                        post("/divide") //ACT
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity()); //ASSERT
    }


    //    extra test cases for endpoint  @PostMapping("/add")
    @Test
    public void responseBodyShouldNotBeEmptyOnSuccessfulResponse() throws Exception {
//        Arrange
        inputDTO.setOperand1(2);
        inputDTO.setOperand2(7);
        String inputJson = mapper.writeValueAsString(inputDTO);

        mockMvc.perform(
                        post("/add") //ACT
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operation").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.answer").isNotEmpty());
    }
}