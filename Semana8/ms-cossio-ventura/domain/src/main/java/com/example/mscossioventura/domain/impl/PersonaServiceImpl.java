package com.example.mscossioventura.domain.impl;

import com.example.mscossioventura.domain.aggregates.request.RequestPersona;
import com.example.mscossioventura.domain.aggregates.response.ResponseBase;
import com.example.mscossioventura.domain.ports.in.PersonaServiceIn;
import com.example.mscossioventura.domain.ports.out.PersonaServiceOut;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonaServiceImpl implements PersonaServiceIn {
    private final PersonaServiceOut personaServiceOut;

    @Override
    public ResponseBase crearPersonaIn(RequestPersona requestPersona) {
        return personaServiceOut.crearPersonaOut(requestPersona);
    }

    @Override
    public ResponseBase consultaPersonaIn(String numDoc) {
        return personaServiceOut.consultaPersonaOut(numDoc);
    }

    @Override
    public ResponseBase consultaPersonasIn() {
        return personaServiceOut.consultaPersonasOut();
    }

    @Override
    public ResponseBase actualizarPersonaIn(Long id, RequestPersona requestPersona) {
        return personaServiceOut.actualizarPersonaOut(id, requestPersona);
    }

    @Override
    public ResponseBase eliminarPersonaIn(Long id) {
        return personaServiceOut.eliminarPersonaOut(id);
    }
}
