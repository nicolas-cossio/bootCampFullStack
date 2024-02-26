package com.pruebasUnitariasB.ApiRest.repository;

import com.pruebasUnitariasB.ApiRest.entity.Empleado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class EmpleadoRepositoryTests {
    @Autowired
    private EmpleadoRepository empleadoRepository;

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
        //given
        Empleado empleado1 = Empleado.builder()
                .nombre("Gabriel")
                .apellido("Retamozo")
                .email("gabriel@gmail.com")
                .build();

        // when
        Empleado empleado2 = empleadoRepository.save(empleado1);

        // then
        assertThat(empleado2).isNotNull();
        assertThat(empleado2.getId()).isGreaterThan(0);
    }

    @Test
    @DisplayName("Test para listar empleados")
    void testListarEmpleados() {
        //given
        Empleado empleado1 = Empleado.builder()
                .nombre("Gabriel")
                .apellido("Retamozo")
                .email("gabriel@gmail.com")
                .build();
        empleadoRepository.save(empleado);
        empleadoRepository.save(empleado1);

        // when
        List<Empleado> empleadoList = empleadoRepository.findAll();

        // then
        assertThat(empleadoList).isNotNull();
        assertThat(empleadoList.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("Test para obtener empleado id")
    void testObtenerEmpleadoId() {
        //given
        empleadoRepository.save(empleado);

        // when
        Empleado empleado1 = empleadoRepository.findById(empleado.getId()).get();

        // then
        assertThat(empleado1).isNotNull();
    }
}
