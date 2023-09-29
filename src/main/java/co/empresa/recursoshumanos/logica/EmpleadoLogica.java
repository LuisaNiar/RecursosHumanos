package co.empresa.recursoshumanos.logica;

import co.empresa.recursoshumanos.controller.dto.EmpleadoDTO;
import co.empresa.recursoshumanos.persistencia.Empleado;
import co.empresa.recursoshumanos.persistencia.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoLogica {

    private EmpleadoRepository empleadoRepository;

    public EmpleadoLogica(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public List<Empleado> obtenerEmpleados() {
        return empleadoRepository.findAll();
    }

    public void guardarEmpleado(EmpleadoDTO empleadoDTO) {
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
    }

    public void actualizarEmpleado(EmpleadoDTO empleadoDTO, int id) {

        Optional<Empleado> empleado = this.empleadoRepository.findById(id);
        Empleado empleadoActualizado = empleado.orElse(null);
        assert empleadoActualizado != null;
        if (empleadoActualizado.isEliminado()) {
            throw new IllegalArgumentException("No sepuede esditar estudiantes eliminados");
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
    }

    public void eliminarEmpleado(int id) {
        Optional<Empleado> empleado = this.empleadoRepository.findById(id);
        Empleado empleadoEliminado = empleado.orElse(null);
        assert empleadoEliminado != null;
        empleadoEliminado.setEliminado(true);
        empleadoRepository.save(empleadoEliminado);
    }
}
