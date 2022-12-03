package com.duett.back.controller;

import com.duett.back.entity.FruitEntity;
import com.duett.back.exceptions.ErrorCreateFruitException;
import com.duett.back.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class FruitController {

    @Autowired
    private FruitService fruitService;

    @PostMapping
    @ResponseBody
    public ResponseEntity save(@RequestBody FruitEntity fruta) {
        try{
            return new ResponseEntity(this.fruitService.save(fruta), HttpStatus.CREATED);
        } catch (ErrorCreateFruitException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(path = "/listAll")
    @ResponseBody
    public Iterable<FruitEntity> findAll() {
        return this.fruitService.findAll();
    }

    @GetMapping(path = "/{id}")
    @ResponseBody
    public ResponseEntity findById(@PathVariable Integer id) throws Exception {
        FruitEntity fruit = this.fruitService.findById(id);

        if(fruit.getId() == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(fruit);
    }


    @PostMapping(path = "/multiplicacao/{id}")
    @ResponseBody
    public double multiply(@PathVariable Integer id) throws Exception {
        return this.fruitService.multiply(id);
    }

    @PostMapping(path = "/divisao/{id}")
    @ResponseBody
    public double division(@PathVariable Integer id) throws Exception {
        return this.fruitService.division(id);
    }
}
