package com.duett.back.repository;


import com.duett.back.entity.FruitEntity;
import org.springframework.data.repository.CrudRepository;

public interface FruitRepository extends CrudRepository<FruitEntity, Integer> {

}
