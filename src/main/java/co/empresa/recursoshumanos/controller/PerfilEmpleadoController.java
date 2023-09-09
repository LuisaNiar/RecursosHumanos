package co.empresa.recursoshumanos.controller;

import co.empresa.recursoshumanos.logica.CertificadoLogica;
import co.empresa.recursoshumanos.logica.PerfilEmpleadoLogica;
import co.empresa.recursoshumanos.persistencia.Certificado;
import co.empresa.recursoshumanos.persistencia.PerfilEmpleado;
import co.empresa.recursoshumanos.persistencia.PerfilEmpleadoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PerfilEmpleadoController {

    private PerfilEmpleadoLogica perfilEmpleadoLogica;

    public PerfilEmpleadoController(PerfilEmpleadoLogica perfilEmpleadoLogica) {
        this.perfilEmpleadoLogica = perfilEmpleadoLogica;
    }

    @GetMapping(path = "/empleado/perfilesempleados")
    public List<PerfilEmpleado> mostrarPerfilesEmpleados() {
        return perfilEmpleadoLogica.obtenerPerfilesEmpleados();
    }


}
