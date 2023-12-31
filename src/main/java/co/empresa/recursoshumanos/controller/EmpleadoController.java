package co.empresa.recursoshumanos.controller;

import co.empresa.recursoshumanos.controller.dto.EmpleadoDTO;
import co.empresa.recursoshumanos.controller.dto.RespuestaDTO;
import co.empresa.recursoshumanos.logica.EmpleadoLogica;
import co.empresa.recursoshumanos.persistencia.Empleado;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Slf4j
public class EmpleadoController {

    private EmpleadoLogica empleadoLogica;
    private static final Logger logger = LoggerFactory.getLogger(EmpleadoController.class);

    public EmpleadoController(EmpleadoLogica empleadoLogica) {
        this.empleadoLogica = empleadoLogica;
    }

    @GetMapping(path = "/empleado")
    public List<Empleado> mostrarEmpleados() {
        logger.info("Mostrar Empleado");
        return empleadoLogica.obtenerEmpleados();
    }

    @PostMapping(path = "/empleado/agregar")
    public RespuestaDTO guardarEmpleado(@RequestBody EmpleadoDTO empleadoDTO) {
        try {
            empleadoLogica.guardarEmpleado(empleadoDTO);
            logger.info("Se agrego Empleado");
            return new RespuestaDTO("Empleado guardado correctamente");
        } catch (IllegalArgumentException e) {
            logger.error("No se pudo guardar Empleado");
            return new RespuestaDTO("Empleado no se pudo guardar " + e.getMessage());
        }

    }

    @RequestMapping(path = "/empleado/actualizar/{id}")
    public RespuestaDTO actualizarEmpleado(@RequestBody EmpleadoDTO empleadoDTO, @PathVariable int id) {
        try {
            empleadoLogica.actualizarEmpleado(empleadoDTO, id);
            logger.info("Se actualizo Empleado");
            return new RespuestaDTO("Empleado actualizado correctamente");
        } catch (IllegalArgumentException e) {
            logger.info("No se pudo actualizar Empleado");
            return new RespuestaDTO("Empleado no se pudo actualizar " + e.getMessage());
        }
    }

    @RequestMapping(path = "/empleado/eliminar/{id}")
    public RespuestaDTO eliminarEmpleado(@PathVariable int id) {
        try {
            empleadoLogica.eliminarEmpleado(id);
            logger.info("Se elimino Empleado");
            return new RespuestaDTO("Empleado actualizado correctamente");
        } catch (IllegalArgumentException e) {
            logger.info("No se pudo eliminar Empleado");
            return new RespuestaDTO("Empleado no se pudo actualizar " + e.getMessage());
        }
    }

}
