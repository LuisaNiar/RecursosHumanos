package co.empresa.recursoshumanos.controller;

import co.empresa.recursoshumanos.logica.CertificadoLogica;
import co.empresa.recursoshumanos.logica.EmpleadoLogica;
import co.empresa.recursoshumanos.persistencia.Certificado;
import co.empresa.recursoshumanos.persistencia.CertificadoRepository;
import co.empresa.recursoshumanos.persistencia.Empleado;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CertificadoController

    private CertificadoLogica certificadoLogica;

    public CertificadoController(CertificadoLogica certificadoLogica) {
        this.certificadoLogica = certificadoLogica;
    }

    @GetMapping(path = "/empleado/certificados")
    public List<Certificado> mostrarCertificados() {
        return certificadoLogica.obtenerCertificados();
    }


}