package co.empresa.recursoshumanos.logica;

import co.empresa.recursoshumanos.persistencia.Certificado;
import co.empresa.recursoshumanos.persistencia.CertificadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificadoLogica {

    private CertificadoRepository certificadoRepository;

    public CertificadoLogica(CertificadoRepository certificadoRepository) {
        this.certificadoRepository = certificadoRepository;
    }

    public List<Certificado> obtenerCertificados() {
        return certificadoRepository.findAll();
    }

}
