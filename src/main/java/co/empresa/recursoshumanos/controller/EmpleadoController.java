package co.empresa.recursoshumanos.controller;

import co.empresa.recursoshumanos.controller.dto.EmpleadoDTO;
import co.empresa.recursoshumanos.controller.dto.RespuestaDTO;
import co.empresa.recursoshumanos.logica.EmpleadoLogica;
import co.empresa.recursoshumanos.persistencia.Empleado;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpleadoController {

    private EmpleadoLogica empleadoLogica;

    public EmpleadoController(EmpleadoLogica empleadoLogica) {
        this.empleadoLogica = empleadoLogica;
    }

    @GetMapping(value = "secured",path = "/empleado")
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

    @PutMapping(path = "/empleado/actualizar/{id}")
    public RespuestaDTO actualizarEmpleado(@RequestBody EmpleadoDTO empleadoDTO, @PathVariable int id) {
        try {
            empleadoLogica.actualizarEmpleado(empleadoDTO, id);
            return new RespuestaDTO("Empleado actualizado correctamente");
        } catch (IllegalArgumentException e) {
            return new RespuestaDTO("Empleado no se pudo actualizar " + e.getMessage());
        }
    }

    @PostMapping(path = "/empleado/eliminar/{id}")
    public RespuestaDTO eliminarEmpleado(@PathVariable int id) {
        try {
            empleadoLogica.eliminarEmpleado(id);
            return new RespuestaDTO("Empleado eliminado correctamente");
        } catch (IllegalArgumentException e) {
            return new RespuestaDTO("Empleado no se pudo eliminar " + e.getMessage());
        }
    }

}
