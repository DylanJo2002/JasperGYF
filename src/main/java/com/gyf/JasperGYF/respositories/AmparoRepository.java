package com.gyf.JasperGYF.respositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gyf.JasperGYF.entities.AmparoEntity;
import com.gyf.JasperGYF.entities.SedeEntity;

@Repository
public interface AmparoRepository extends CrudRepository<AmparoEntity, Integer> {

}
