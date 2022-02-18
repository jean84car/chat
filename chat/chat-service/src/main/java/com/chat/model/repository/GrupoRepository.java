package com.chat.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chat.model.GrupoEntity;

@Repository
public interface GrupoRepository extends CrudRepository<GrupoEntity, Long> {

}
