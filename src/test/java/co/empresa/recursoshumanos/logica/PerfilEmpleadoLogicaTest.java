package co.empresa.recursoshumanos.logica;

import co.empresa.recursoshumanos.persistencia.Certificado;
import co.empresa.recursoshumanos.persistencia.CertificadoRepository;
import co.empresa.recursoshumanos.persistencia.PerfilEmpleado;
import co.empresa.recursoshumanos.persistencia.PerfilEmpleadoRepository;
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
class PerfilEmpleadoLogicaTest {

    @InjectMocks
    PerfilEmpleadoLogica logica;

    @Mock
    PerfilEmpleadoRepository repository;

    @Test
    void Cuando_invoque_obtenerPerfilesEmpleados_entonces_da_1() {
        PerfilEmpleado perf = new PerfilEmpleado();
        perf.setID(1);
        ArrayList<PerfilEmpleado> value = new ArrayList<>();
        value.add(perf);
        Mockito.when(repository.findAll()).thenReturn(value);
        List<PerfilEmpleado> perfiles = logica.obtenerPerfilesEmpleados();
        assertEquals(1, perfiles.get(0).getID());
    }
}