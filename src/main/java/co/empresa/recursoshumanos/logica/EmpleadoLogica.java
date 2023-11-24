package co.empresa.recursoshumanos.logica;

import co.empresa.recursoshumanos.controller.dto.EmpleadoDTO;
import co.empresa.recursoshumanos.persistencia.Empleado;
import co.empresa.recursoshumanos.persistencia.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class EmpleadoLogica {

    private EmpleadoRepository empleadoRepository;

    public EmpleadoLogica(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public List<Empleado> obtenerEmpleados() {
        List<Empleado> listaEmpleados = new ArrayList(empleadoRepository.findAll());
        Predicate<Empleado> predicate = empleado -> !empleado.isEliminado();

        return listaEmpleados.stream().filter(predicate).collect(Collectors.toList());
    }

    public Empleado guardarEmpleado(EmpleadoDTO empleadoDTO) {
        Empleado empleadoGuardado = new Empleado();
        empleadoGuardado.setNombre(empleadoDTO.getNombre());
        empleadoGuardado.setApellido(empleadoDTO.getApellido());
        empleadoGuardado.setCedula(empleadoDTO.getCedula());
        empleadoGuardado.setTelefono(empleadoDTO.getTelefono());
        empleadoGuardado.setPuesto(empleadoDTO.getPuesto());
        empleadoGuardado.setSalario(empleadoDTO.getSalario());
        empleadoGuardado.setVacaciones(empleadoDTO.getVacaciones());
        empleadoGuardado.setEliminado(false);
        empleadoRepository.save(empleadoGuardado);
        return empleadoGuardado;
    }

    public Empleado actualizarEmpleado(EmpleadoDTO empleadoDTO, int id) {

        Optional<Empleado> empleado = this.empleadoRepository.findById(id);
        Empleado empleadoActualizado = empleado.orElse(null);

        if (empleadoActualizado.isEliminado()) {
            throw new IllegalArgumentException("No se puede editar empleados eliminados");
        } else {
            empleadoActualizado.setNombre(empleadoDTO.getNombre());
            empleadoActualizado.setApellido(empleadoDTO.getApellido());
            empleadoActualizado.setCedula(empleadoDTO.getCedula());
            empleadoActualizado.setTelefono(empleadoDTO.getTelefono());
            empleadoActualizado.setPuesto(empleadoDTO.getPuesto());
            empleadoActualizado.setSalario(empleadoDTO.getSalario());
            empleadoActualizado.setVacaciones(empleadoDTO.getVacaciones());
            empleadoRepository.save(empleadoActualizado);
        }
        return empleadoActualizado;
    }

    public Empleado eliminarEmpleado(int id) {
        Optional<Empleado> empleado = this.empleadoRepository.findById(id);
        Empleado empleadoEliminado = empleado.orElse(null);
        empleadoEliminado.setEliminado(true);
        empleadoRepository.save(empleadoEliminado);
        return empleadoEliminado;
    }
}
