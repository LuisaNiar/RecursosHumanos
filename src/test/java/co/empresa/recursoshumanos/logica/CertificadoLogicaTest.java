package co.empresa.recursoshumanos.logica;

import co.empresa.recursoshumanos.persistencia.Certificado;
import co.empresa.recursoshumanos.persistencia.CertificadoRepository;
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

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CertificadoLogicaTest {

    @InjectMocks
    CertificadoLogica logica;

    @Mock
    CertificadoRepository repository;

    @Test
    void Cuando_invoque_obtenerCertificados_entonces_da_1() {
        Certificado cert = new Certificado();
        cert.setId(1);
        ArrayList<Certificado> value = new ArrayList<>();
        value.add(cert);
        Mockito.when(repository.findAll()).thenReturn(value);
        List<Certificado> certificados = logica.obtenerCertificados();
        assertEquals(1, certificados.get(0).getId());
    }
}