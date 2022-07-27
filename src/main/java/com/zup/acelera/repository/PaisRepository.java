package com.zup.acelera.repository;

import com.zup.acelera.model.Pais;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaisRepository extends CrudRepository<Pais, Long> {

    Optional<Pais> findById(Long id);
}
