package co.empresa.recursoshumanos.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@WebAppConfiguration
class CertificadoControllerTest {

    private  final static String BASE_URL = "/empleado/certificados";
    MockMvc mocMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    void serUp(){
        mocMvc= MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void mostrarCertificados() throws Exception {
        MvcResult mockMvcResult = mocMvc.perform(MockMvcRequestBuilders.get(BASE_URL).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        assertEquals(200,mockMvcResult.getResponse().getStatus());
    }
}