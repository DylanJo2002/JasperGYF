package com.gyf.JasperGYF.respositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gyf.JasperGYF.entities.SedeEntity;

@Repository
public interface SedeRepository extends CrudRepository<SedeEntity, Integer> {

}
