package com.codigo.msregistro.infraestructure.adapters;

import com.codigo.msregistro.domain.aggregates.dto.PersonaDTO;
import com.codigo.msregistro.domain.aggregates.request.RequestPersona;
import com.codigo.msregistro.domain.aggregates.response.ResponseReniec;
import com.codigo.msregistro.infraestructure.entity.PersonaEntity;
import com.codigo.msregistro.infraestructure.mapper.PersonaMapper;
import com.codigo.msregistro.infraestructure.repository.PersonaRepository;
import com.codigo.msregistro.infraestructure.repository.TipoDocumentoRepository;
import com.codigo.msregistro.infraestructure.rest.client.ClienteReniec;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

class PersonaAdapterOtherTest {
    @Mock
    private PersonaRepository personaRepository;
    @Mock
    private TipoDocumentoRepository tipoDocumentoRepository;
    @Mock
    private PersonaMapper personaMapper;
    @Mock
    private ClienteReniec reniec;

    @InjectMocks
    private PersonaAdapterOther personaAdapterOther;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void crearPersonaOutSuccess() {
        // Preparar nuestros datos para el test
        RequestPersona requestPersona = new RequestPersona("DNI", "72032008");
        ResponseReniec datosReniec = getResponseReniec();
        ReflectionTestUtils.setField(personaAdapterOther, "tokenApi", "X", String.class);

        // Comportamiento
        when(reniec.getInfoReniec(anyString(), anyString())).thenReturn(datosReniec);

        // Verificar
        assertDoesNotThrow(() -> personaAdapterOther.crearPersonaOut(requestPersona));
    }

    @Test
    void crearPersonaOutErrorApiReniec() {
        // ARRANGE - ORGANIZAR
        // Preparar nuestros datos para el test
        RequestPersona requestPersona = new RequestPersona("DNI", "72032008");
        ReflectionTestUtils.setField(personaAdapterOther, "tokenApi", "X", String.class);

        // ACT - ACTUAR
        // Comportamiento
        when(reniec.getInfoReniec(anyString(), anyString())).thenThrow(RuntimeException.class);

        // ASSERT - AFIRMAR
        // Verificar
        assertThrows(Exception.class, () -> personaAdapterOther.crearPersonaOut(requestPersona));
    }

    @Test
    void obtenerPersonaOut_whenPersonaExists_returnsPersonaDTO() {
        // ARRANGE - ORGANIZAR
        Long id = 1L;
        PersonaEntity entity = new PersonaEntity();
        Optional<PersonaEntity> optionalEntity = Optional.of(entity);
        PersonaDTO expectedDTO = new PersonaDTO();

        // ACT - ACTUAR
        when(personaRepository.findById(id)).thenReturn(optionalEntity);
        when(personaMapper.mapToDto(entity)).thenReturn(expectedDTO);

        // ASSERT - AFIRMAR
        Optional<PersonaDTO> result = personaAdapterOther.obtenerPersonaOut(id);
        assertTrue(result.isPresent());
        assertEquals(expectedDTO, result.get());
    }

    @Test
    void obtenerPersonaOut_whenPersonaDoesNotExists_returnsEmptyOptional() {
        // ARRANGE - ORGANIZAR
        Long id = 2L;

        // ACT - ACTUAR
        when(personaRepository.findById(id)).thenReturn(Optional.empty());

        // ASSERT - AFIRMAR
        Optional<PersonaDTO> result = personaAdapterOther.obtenerPersonaOut(id);
        assertTrue(result.isEmpty());
    }

    private ResponseReniec getResponseReniec() {
        return new ResponseReniec("Juan", "Perez",
                "Lopez", "DNI",
                "720320083","2");
    }
}