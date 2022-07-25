package com.zup.acelera.novoautor;

import com.zup.acelera.model.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private EmailAutorDuplicadoValidator emailAutorDuplicadoValidator;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(emailAutorDuplicadoValidator);
    }

    @PostMapping
    @Transactional
    public String criar(@RequestBody @Valid NovoAutorRequest request){
        Autor autor = request.toModel();
        entityManager.persist(autor);
        return autor.toString();
    }

}
