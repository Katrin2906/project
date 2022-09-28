package com.cosmetelogy.controller;

import com.cosmetelogy.dto.PersonDto;
import com.cosmetelogy.dto.ProductDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
@SpringBootTest
class PersonControllerIT {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void save() throws Exception {
        //Given
        String path = "/person/save";
        PersonDto personDto = new PersonDto(1L, "Zina", "f", 22, null, "121212", null, null);
        MockHttpServletRequestBuilder postPerson = MockMvcRequestBuilders
                .post(path)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(personDto));
        String expected = "1";
        //When
        MvcResult mvcResult = mockMvc.perform(postPerson)
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andReturn();

        //Then
        Assertions.assertEquals(expected, mvcResult.getResponse().getContentAsString());

    }

    @Test
    void testSave() throws Exception {
        //Given
        String path = "/person/save/product";
        ProductDto productDto = new ProductDto(2L, "Serum", 6.5, null, "naturally", "DKM");
        MockHttpServletRequestBuilder postProduct = MockMvcRequestBuilders
                .post(path)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productDto));
        String expected = "2";

        //When
        MvcResult mvcResult = mockMvc.perform(postProduct)
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andReturn();
        //Then
        Assertions.assertEquals(expected, mvcResult.getResponse().getContentAsString());
    }

    @Test
    void findById() {
    }

    @Test
    void findAllByName() {
    }

    @Test
    void deleteById() {
    }
}