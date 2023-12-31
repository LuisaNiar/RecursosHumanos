package co.empresa.recursoshumanos.controller;

import co.empresa.recursoshumanos.logica.PerfilEmpleadoLogica;
import co.empresa.recursoshumanos.persistencia.PerfilEmpleado;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Slf4j
public class PerfilEmpleadoController {

    private PerfilEmpleadoLogica perfilEmpleadoLogica;
    private static final Logger logger = LoggerFactory.getLogger(PerfilEmpleadoController.class);
    public PerfilEmpleadoController(PerfilEmpleadoLogica perfilEmpleadoLogica) {
        this.perfilEmpleadoLogica = perfilEmpleadoLogica;
    }

    @GetMapping(path = "/empleado/perfilesempleados")
    public List<PerfilEmpleado> mostrarPerfilesEmpleados() {
        logger.info("Mostrar Perfil Empleados. ");
        return perfilEmpleadoLogica.obtenerPerfilesEmpleados();
    }


}
