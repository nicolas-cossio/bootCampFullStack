package com.codigo.msregistro.domain.impl;

import com.codigo.msregistro.domain.aggregates.response.ResponseReniec;
import com.codigo.msregistro.domain.ports.in.RestReniecIn;
import com.codigo.msregistro.domain.ports.out.RestReniecOut;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReniecServiceImpl implements RestReniecIn {
    private final RestReniecOut restReniecOut;

    @Override
    public ResponseReniec getInfoIn(String numDoc) {
        return restReniecOut.getInfoReniec(numDoc);
    }
}
