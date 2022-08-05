package com.zup.acelera.novolivro;

import com.zup.acelera.model.Livro;
import com.zup.acelera.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private LivroRepository livroRepository;

    @PostMapping
    @Transactional
    public String novoLivro(@RequestBody @Valid NovoLivroRequest request){
        Livro novoLivro = request.toModel(entityManager);
        entityManager.persist(novoLivro);
        return novoLivro.toString();
    }

    @GetMapping
    public ResponseEntity<?> listLvros(){
        List<Livro> livros = livroRepository.findAll();

        if(livros.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(LivroDTO.converter(livros));
    }
}
