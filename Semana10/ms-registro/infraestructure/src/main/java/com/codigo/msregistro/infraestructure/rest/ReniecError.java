package com.codigo.msregistro.infraestructure.rest;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@Slf4j
public class ReniecError implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {
        try {
            String getBody = this.getBody(response);
            log.error("ERROR en feign decoder");
            return new RuntimeException(getBody, new Throwable(getBody));
        } catch (Exception e) {
            log.error("No se pudo decodificar la respuesta");
            return e;
        }
    }

    private String getBody(Response response) throws IOException {
        Response.Body body = response.body();
        if(!Objects.isNull(body)) {
            InputStream inputStream = body.asInputStream();
            final String bodyError = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
            inputStream.close();
            return bodyError;
        } else {
            return StringUtils.EMPTY;
        }
    }
}
