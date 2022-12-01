package com.duett.back.service;

import com.duett.back.entity.FrutaEntity;
import com.duett.back.repository.FrutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class FrutaService {

    @Autowired
    private FrutaRepository frutaRepository;

    @Transactional(rollbackFor = Exception.class)
    public FrutaEntity salvar(FrutaEntity fruta) {
        return this.frutaRepository.save(fruta);
    }

    @Transactional(rollbackFor = Exception.class)
    public Iterable<FrutaEntity> findAll() {
        return this.frutaRepository.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    public Optional<FrutaEntity> findById(Integer id) {
        return this.frutaRepository.findById(id);
    }
}
