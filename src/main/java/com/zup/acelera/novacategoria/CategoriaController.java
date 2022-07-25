package com.zup.acelera.novacategoria;

import com.zup.acelera.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public String novaCategoria(@RequestBody @Valid NovaCategoriaRequest request){
        Categoria categoria = request.toModel();
        entityManager.persist(categoria);
        return categoria.toString();

    }
}
