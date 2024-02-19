package com.example.mscossioventura.infrastructure.rest.client;

import com.example.mscossioventura.domain.aggregates.response.ResponseReniec;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "reniec-client", url = "https://api.apis.net.pe/v2/reniec")
public interface ClientReniec {

    @GetMapping("/dni")
    ResponseReniec getInfo(@RequestParam("numero") String numero,
                           @RequestHeader("Authorization") String token);

}