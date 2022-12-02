package com.duett.back.service.impl;

import com.duett.back.entity.FruitEntity;
import com.duett.back.exceptions.ErrorCreateFruitException;
import com.duett.back.repository.FruitRepository;
import com.duett.back.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FruitServiceImpl implements FruitService {

    @Autowired
    private FruitRepository fruitRepository;

    @Transactional(rollbackFor = Exception.class)
    public FruitEntity save(FruitEntity fruit) {
        validaCriacao(fruit);
        return this.fruitRepository.save(fruit);
    }

    private void validaCriacao(FruitEntity fruit) {
        if(fruit.getDescricao() == null || fruit.getDescricao().trim().equals("")){
            throw new ErrorCreateFruitException("Informe uma descrição válida.");
        }
        if(fruit.getValorA() < 0){
            throw new ErrorCreateFruitException("O valor de A não pode ser menor que zero.");
        }
        if(fruit.getValorB() < 0){
            throw new ErrorCreateFruitException("O valor de B não pode ser menor que zero.");
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public Iterable<FruitEntity> findAll() {
        return this.fruitRepository.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    public FruitEntity findById(Integer id) throws Exception {
        return this.fruitRepository.findById(id)
                .orElseThrow(() -> new Exception("Fruta não encontrada."));
    }

    public double multiply(Integer id) throws Exception {
        FruitEntity fruit = this.findById(id);
        return fruit.getValorA() * fruit.getValorB();
    }

    public double division(Integer id) throws Exception {
        FruitEntity fruit = this.findById(id);
        return fruit.getValorA() / fruit.getValorB();
    }
}
