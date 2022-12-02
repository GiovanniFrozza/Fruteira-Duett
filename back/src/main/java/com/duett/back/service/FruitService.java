package com.duett.back.service;

import com.duett.back.entity.FruitEntity;

public interface FruitService {
    FruitEntity save(FruitEntity fruit);

    Iterable<FruitEntity> findAll();

    FruitEntity findById(Integer id) throws Exception;

    double multiply(Integer id) throws Exception;

    double division(Integer id) throws Exception;
}
