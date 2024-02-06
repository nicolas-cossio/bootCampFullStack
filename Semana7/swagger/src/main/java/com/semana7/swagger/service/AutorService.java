package com.semana7.swagger.service;

import com.semana7.swagger.model.Autor;
import com.semana7.swagger.request.AutorRequest;
import com.semana7.swagger.response.AutorResponse;


import java.util.List;

public interface AutorService {
    AutorResponse createAutor(AutorRequest autor);
    List<Autor> getAll();
    Autor getById(Integer id);
    Autor update(Integer id, Autor autor);
    Autor delete(Integer id);
}
