package co.empresa.recursoshumanos.logica;

import co.empresa.recursoshumanos.controller.dto.EmpleadoDTO;
import co.empresa.recursoshumanos.persistencia.Empleado;
import co.empresa.recursoshumanos.persistencia.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        Empleado empleadoBD = new Empleado();

        empleadoBD.setNombre(empleadoDTO.getNombre());
        empleadoBD.setApellido(empleadoDTO.getApellido());
        empleadoBD.setCedula(empleadoDTO.getCedula());
        empleadoBD.setTelefono(empleadoDTO.getTelefono());
        empleadoBD.setPuesto(empleadoDTO.getPuesto());
        empleadoBD.setSalario(empleadoDTO.getSalario());
        empleadoBD.setVacaciones(empleadoDTO.getVacaciones());
        empleadoRepository.save(empleadoBD);
    }


    public void eliminarEmpleado(int id) {
        empleadoRepository.deleteById(id);
    }
}
