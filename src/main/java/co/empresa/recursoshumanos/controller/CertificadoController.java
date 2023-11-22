package co.empresa.recursoshumanos.controller;

import co.empresa.recursoshumanos.logica.CertificadoLogica;
import co.empresa.recursoshumanos.persistencia.Certificado;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Slf4j
public class CertificadoController {

    private CertificadoLogica certificadoLogica;
    private static final Logger logger = LoggerFactory.getLogger(CertificadoController.class);
    public CertificadoController(CertificadoLogica certificadoLogica) {
        this.certificadoLogica = certificadoLogica;
    }

    @GetMapping(path = "/empleado/certificados")
    public List<Certificado> mostrarCertificados() {
        logger.info("Mostrar Certificados");
        return certificadoLogica.obtenerCertificados();
    }


}