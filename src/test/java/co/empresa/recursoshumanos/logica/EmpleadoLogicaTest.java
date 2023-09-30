package co.empresa.recursoshumanos.logica;

import co.empresa.recursoshumanos.controller.dto.EmpleadoDTO;
import co.empresa.recursoshumanos.persistencia.Empleado;
import co.empresa.recursoshumanos.persistencia.EmpleadoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EmpleadoLogicaTest {

    @InjectMocks
    EmpleadoLogica logica;

    @Mock
    EmpleadoRepository repository;

    @Test
    void Cuando_invoque_obtenerEmpleados_entonces_da_carlos() {
        Empleado emple = new Empleado();
        emple.setNombre("carlos");
        ArrayList<Empleado> value = new ArrayList<>();
        value.add(emple);
        Mockito.when(repository.findAll()).thenReturn(value);
        List<Empleado> empleados = logica.obtenerEmpleados();
        assertEquals("carlos", empleados.get(0).getNombre());
    }

    @Test
    void Cuando_invoque_guardarEmpleado_entonces_da_carlos() {

        EmpleadoDTO empleadoDTO = new EmpleadoDTO();
        empleadoDTO.setNombre("carlos");
        empleadoDTO.setApellido("barrera");
        empleadoDTO.setCedula(123456);
        empleadoDTO.setTelefono(999999999);
        empleadoDTO.setPuesto("celador");
        empleadoDTO.setSalario(1000000);
        empleadoDTO.setVacaciones(15);
        empleadoDTO.setEliminado(false);
        Empleado empleado =logica.guardarEmpleado(empleadoDTO);
        assertEquals("carlos", empleado.getNombre());
        Mockito.verify(repository).save(empleado);
    }

    @Test
    void Cuando_invoque_actualizarEmpleado_entonces_da_Exception() {
        Empleado emple = new Empleado();
        emple.setEliminado(true);
        Mockito.when(repository.findById(1)).thenReturn(Optional.of(emple));
        EmpleadoDTO empleadoDTO2 = new EmpleadoDTO();
        assertThrows(Exception.class, () ->{
            Empleado empleadoA =logica.actualizarEmpleado(empleadoDTO2,1);
        });
    }

    @Test
    void Cuando_invoque_actualizarEmpleado_entonces_da_juan() {
        Empleado emple = new Empleado();
        emple.setNombre("carlos");
        Mockito.when(repository.findById(1)).thenReturn(Optional.of(emple));
        EmpleadoDTO empleadoDTO2 = new EmpleadoDTO();
        empleadoDTO2.setNombre("juan");
        Empleado actualizado = logica.actualizarEmpleado(empleadoDTO2,1);
        assertEquals("juan", actualizado.getNombre());
    }

    @Test
    void Cuando_invoque_eliminarEmpleado_entonces_da_carlos() {
        Empleado emple = new Empleado();
        emple.setNombre("carlos");
        Mockito.when(repository.findById(1)).thenReturn(Optional.of(emple));
        Empleado eliminado = logica.eliminarEmpleado(1);
        assertEquals("carlos", eliminado.getNombre());
    }
}