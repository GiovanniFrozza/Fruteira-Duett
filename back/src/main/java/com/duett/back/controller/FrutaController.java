package com.duett.back.controller;

import com.duett.back.entity.FrutaEntity;
import com.duett.back.service.FrutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/api")
public class FrutaController {

    @Autowired
    private FrutaService frutaService;

    @PostMapping
    @ResponseBody
    public FrutaEntity salvar(@RequestBody FrutaEntity fruta) {
        return this.frutaService.salvar(fruta);
    }

    @GetMapping(path = "/listaTodos")
    @ResponseBody
    public Iterable<FrutaEntity> lista() {
        return this.frutaService.findAll();
    }

    @GetMapping(path = "/{id}")
    @ResponseBody
    public Optional<FrutaEntity> encontraId(@PathVariable Integer id) {
        return this.frutaService.findById(id);
    }
}
