package com.codigo.msregistro.domain.ports.in;

import com.codigo.msregistro.domain.aggregates.response.ResponseReniec;

public interface RestReniecIn {
    ResponseReniec getInfoIn(String numDoc);

}
