package com.example.mscossioventura.domain.ports.in;

import com.example.mscossioventura.domain.aggregates.request.RequestPersona;
import com.example.mscossioventura.domain.aggregates.response.ResponseBase;

public interface PersonaServiceIn {
    // Se va utilizar un response base para devolver una respuesta con codigo y messange personalizado.
    ResponseBase crearPersonaIn(RequestPersona requestPersona);
    ResponseBase consultaPersonaIn(String numDoc);
    ResponseBase consultaPersonasIn();
    ResponseBase actualizarPersonaIn(Long id, RequestPersona requestPersona);
    ResponseBase eliminarPersonaIn(Long id);
}
