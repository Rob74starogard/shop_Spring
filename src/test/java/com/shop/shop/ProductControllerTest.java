package com.shop.shop;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.shop.model.ProductDto;
import com.shop.shop.service.Productmanager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;
import java.util.List;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Productmanager productmanager;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testAddProduct() throws Exception {
        ProductDto productDto = new ProductDto(1, "product1", 1);


        mockMvc.perform(MockMvcRequestBuilders.post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(productDto)))
                .andExpect(MockMvcResultMatchers.status().isOk());

        Mockito.verify(productmanager, Mockito.times(1)).productAdd(Mockito.any(ProductDto.class));
    }

    @Test
    public void testGetProducts() throws Exception {
        List<ProductDto> productList = Collections.singletonList(new ProductDto(1, "product1", 1));
        Mockito.when(productmanager.getAllProducts()).thenReturn(productList);

        mockMvc.perform(MockMvcRequestBuilders.get("/products/getall"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(productList.size()));

        Mockito.verify(productmanager, Mockito.times(1)).getAllProducts();
    }
}
