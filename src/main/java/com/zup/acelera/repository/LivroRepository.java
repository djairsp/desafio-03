package com.zup.acelera.repository;

import com.zup.acelera.model.Livro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends CrudRepository<Livro, Long> {

    List<Livro> findAll();
}
