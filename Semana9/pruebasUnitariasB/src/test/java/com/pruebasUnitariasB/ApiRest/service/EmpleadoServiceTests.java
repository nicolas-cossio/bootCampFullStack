package com.pruebasUnitariasB.ApiRest.service;

import com.pruebasUnitariasB.ApiRest.entity.Empleado;
import com.pruebasUnitariasB.ApiRest.repository.EmpleadoRepository;
import com.pruebasUnitariasB.ApiRest.service.Impl.EmpleadoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class EmpleadoServiceTests {

    @Mock
    private EmpleadoRepository empleadoRepository;

    @InjectMocks
    private EmpleadoServiceImpl empleadoServiceImpl;


    private Empleado empleado;

    @BeforeEach
    void setup() {
        empleado = Empleado.builder()
                .nombre("Nicolas")
                .apellido("Suarez")
                .email("nicolas@gmail.com")
                .build();
    }

    @Test
    @DisplayName("Test para guardar una entidad")
    void testGuardarEmpleado() {
        // given
        given(empleadoRepository.findByEmail(empleado.getEmail())).willReturn(Optional.empty());
        given(empleadoRepository.save(empleado)).willReturn(empleado);

        // when
        Empleado empleado1 = empleadoServiceImpl.guardarEmpleado(empleado);

        // then
        assertThat(empleado1).isNotNull();
    }

    @Test
    @DisplayName("Test para listar empleados")
    void testListarEmpleados() {
        // given
        Empleado empleado1 = Empleado.builder()
                .id(1L)
                .nombre("Gabriel")
                .apellido("Retamozo")
                .email("gabriel@gmail.com")
                .build();
       given(empleadoRepository.findAll()).willReturn(List.of(empleado, empleado1));

        // when
        List<Empleado> empleadoList = empleadoServiceImpl.getAllEmpleados();

        // then
        assertThat(empleadoList).isNotNull();
        assertThat(empleadoList.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("Test para obtener empleado por id")
    void testObtenerEmpleadoId() {
        //given
        given(empleadoRepository.findById(empleado.getId())).willReturn(Optional.of(empleado));

        // when
        Empleado empleado1 = empleadoServiceImpl.getEmpleadoById(empleado.getId()).get();

        // then
        assertThat(empleado1).isNotNull();
    }

}
