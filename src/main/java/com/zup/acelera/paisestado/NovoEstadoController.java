package com.zup.acelera.paisestado;

import com.zup.acelera.model.Estado;
import com.zup.acelera.model.Pais;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("estados")
public class NovoEstadoController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<?> criarEstado(@RequestBody @Valid NovoEstadoRequest request){
        Estado estado = request.toModel(manager);
        manager.persist(estado);
        return ResponseEntity.ok(estado);
    }
}
