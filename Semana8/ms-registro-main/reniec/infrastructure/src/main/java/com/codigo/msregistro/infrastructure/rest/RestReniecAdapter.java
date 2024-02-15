package com.codigo.msregistro.infrastructure.rest;

import com.codigo.msregistro.domain.aggregates.response.ResponseReniec;
import com.codigo.msregistro.domain.ports.out.RestReniecOut;
import com.codigo.msregistro.infrastructure.rest.client.ClientReniec;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestReniecAdapter implements RestReniecOut {

    private final ClientReniec clienteReniec;

    @Value("${token.api}")
    private String token;

    @Override
    public ResponseReniec getInfoReniec(String numDoc) {
        String auth = "Bearer " + token;
        ResponseReniec responseReniec = clienteReniec.getInfo(numDoc, auth);
        return responseReniec;
    }
}
