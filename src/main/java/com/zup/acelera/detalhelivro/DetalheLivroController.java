package com.zup.acelera.detalhelivro;

import com.zup.acelera.model.Livro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RestController
@RequestMapping("detalhes")
public class DetalheLivroController {

    @PersistenceContext
    private EntityManager manager;

    @GetMapping("/{id}")
    public ResponseEntity<?> detalheLivro(@PathVariable("id") Long id){
        Livro livroBuscado = manager.find(Livro.class, id);
        if(livroBuscado == null){
            return ResponseEntity.notFound().build();
        }

        DetalheLivroResponse detalheLivroResponse = new DetalheLivroResponse(livroBuscado);
        return ResponseEntity.ok(detalheLivroResponse);
    }
}
