package com.zup.acelera.paisestado;

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
@RequestMapping("pais")
public class NovoPaisController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<?> criarPais(@RequestBody @Valid NovoPaisRequest request){
        Pais pais = request.toModel();
        manager.persist(pais);
        return ResponseEntity.ok(pais);
    }
}
