package co.empresa.recursoshumanos.logica;

import co.empresa.recursoshumanos.persistencia.PerfilEmpleado;
import co.empresa.recursoshumanos.persistencia.PerfilEmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilEmpleadoLogica {

    public PerfilEmpleadoRepository perfilEmpleadoRepository;

    public PerfilEmpleadoLogica(PerfilEmpleadoRepository perfilEmpleadoRepository) {
        this.perfilEmpleadoRepository = perfilEmpleadoRepository;
    }

    public List<PerfilEmpleado> obtenerPerfilesEmpleados() {
        return perfilEmpleadoRepository.findAll();
    }
}
