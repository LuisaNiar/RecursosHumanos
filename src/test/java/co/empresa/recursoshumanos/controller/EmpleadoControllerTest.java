
package co.empresa.recursoshumanos.controller;

import co.empresa.recursoshumanos.controller.dto.EmpleadoDTO;
import co.empresa.recursoshumanos.controller.dto.RespuestaDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@WebAppConfiguration

class EmpleadoControllerTest {

    private  final static String BASE_URL = "/empleado";
    MockMvc mocMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    void serUp(){
        mocMvc= MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void mostrarEmpleados() throws Exception {
        MvcResult mockMvcResult = mocMvc.perform(MockMvcRequestBuilders.get(BASE_URL).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        assertEquals(200,mockMvcResult.getResponse().getStatus());
    }

    @Test
    void guardarEmpleado() throws Exception {
        EmpleadoDTO empleadoDTO = buildEmpleadoDTO();
        MvcResult mockMvcResult = mocMvc.perform(MockMvcRequestBuilders.get(BASE_URL).accept(MediaType.APPLICATION_JSON_VALUE).content(mapToJson(empleadoDTO))).andReturn();
        assertEquals(200, mockMvcResult.getResponse().getStatus());
    }

    private String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper mapper= new ObjectMapper();
        return mapper.writeValueAsString(object);
    }

    private EmpleadoDTO buildEmpleadoDTO(){
        EmpleadoDTO empleadoDTO = new EmpleadoDTO();
        empleadoDTO.setNombre("carlos");
        empleadoDTO.setApellido("barrera");
        empleadoDTO.setCedula(123456);
        empleadoDTO.setTelefono(999999999);
        empleadoDTO.setPuesto("celador");
        empleadoDTO.setSalario(1000000);
        empleadoDTO.setVacaciones(15);
        empleadoDTO.setEliminado(false);
        return empleadoDTO;
    }
}

