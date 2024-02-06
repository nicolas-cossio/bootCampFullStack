package com.semana7.swagger.service.impl;

import com.semana7.swagger.model.Autor;
import com.semana7.swagger.repository.AutorRepository;
import com.semana7.swagger.request.AutorRequest;
import com.semana7.swagger.response.AutorResponse;
import com.semana7.swagger.service.AutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AutorServiceImpl implements AutorService {
    private final AutorRepository autorRepository;

    @Override
    public AutorResponse createAutor(AutorRequest autorReq) {
        Autor autor = new Autor();
        autor.reqToModel(autorReq);
        autor.setEstado(1);
        autor.setUserCreate("Nicolas");
        autor.setDateCreate(getTimestamp());

        Autor autorSave = autorRepository.save(autor);
        return new AutorResponse(autorSave);
    }

    @Override
    public List<Autor> getAll() {
        return autorRepository.findAll();
    }

    @Override
    public Autor getById(Integer id) {
        Optional<Autor> autor = autorRepository.findById(id);
        if(autor.isPresent()) {
            return autor.get();
        }
        else {
            return null;
        }
    }

    @Override
    public Autor update(Integer id, Autor autor) {
        boolean exists = autorRepository.existsById(id);
        if (exists) {
            Optional<Autor> autorBd = autorRepository.findById(id);
            Autor autorUpdate = autorBd.get();
            autorUpdate.setNombres(autor.getNombres());
            autorUpdate.setApellidos(autor.getApellidos());
            return autorRepository.save(autorUpdate);
        } else {
            return null;
        }
    }

    @Override
    public Autor delete(Integer id) {
        boolean exists = autorRepository.existsById(id);
        if (exists) {
            Optional<Autor> autorBd = autorRepository.findById(id);
            Autor autorDelete = autorBd.get();
            autorDelete.setEstado(0);
            return autorRepository.save(autorDelete);
        } else {
            return null;
        }
    }

    private Timestamp getTimestamp() {
        long currentTime = System.currentTimeMillis();
        return new Timestamp(currentTime);
    }
}
