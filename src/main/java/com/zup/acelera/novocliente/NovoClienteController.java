package com.zup.acelera.novocliente;

import com.zup.acelera.model.Cliente;
import com.zup.acelera.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("clientes")
public class NovoClienteController {

    @Autowired
    private PaisRepository paisRepository;

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<?> criarCliente(@RequestBody @Valid NovoClienteRequest request) {
        Cliente cliente = request.toModel(paisRepository);
        manager.persist(cliente);
        return ResponseEntity.ok(cliente);
    }
}
