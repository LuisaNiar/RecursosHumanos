package co.empresa.recursoshumanos.controller;

import co.empresa.recursoshumanos.controller.dto.EmpleadoDTO;
import co.empresa.recursoshumanos.controller.dto.RespuestaDTO;
import co.empresa.recursoshumanos.logica.EmpleadoLogica;
import co.empresa.recursoshumanos.persistencia.Empleado;
import co.empresa.recursoshumanos.persistencia.EmpleadoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmpleadoController {

    private EmpleadoLogica empleadoLogica;

    public EmpleadoController(EmpleadoLogica empleadoLogica) {
        this.empleadoLogica = empleadoLogica;
    }

    @GetMapping(path = "/empleado")
    public List<Empleado> mostrarEmpleados() {
        return empleadoLogica.obtenerEmpleados();
    }

    @PostMapping(path = "/empleado/agregar")
    public RespuestaDTO guardarEmpleado(@RequestBody EmpleadoDTO empleadoDTO) {
        try {
            empleadoLogica.guardarEmpleado(empleadoDTO);
            return new RespuestaDTO("Empleado guardado correctamente");
        } catch (IllegalArgumentException e) {
            return new RespuestaDTO("Empleado no se pudo guardar " + e.getMessage());
        }

    }

    @RequestMapping(path = "/empleado/eliminar/{id}", method = RequestMethod.DELETE)
    public RespuestaDTO eliminarEmpleado(@PathVariable int id) {
        try {
            empleadoLogica.eliminarEmpleado(id);
            return new RespuestaDTO("Empleado eliminado correctamente");
        } catch (IllegalArgumentException e) {
            return new RespuestaDTO("Empleado no se pudo eliminar " + e.getMessage());
        }
    }

}
