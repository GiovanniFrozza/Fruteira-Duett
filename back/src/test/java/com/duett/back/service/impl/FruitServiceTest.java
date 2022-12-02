package com.duett.back.service.impl;

import com.duett.back.entity.FruitEntity;
import com.duett.back.repository.FruitRepository;
import com.duett.back.stub.FruitEntityStub;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FruitServiceTest {
    @InjectMocks
    private FruitServiceImpl fruitServiceImpl;
    @Mock
    private FruitRepository fruitRepository;

    @Test
    public void createFruitTest() {
        FruitEntity fruit = FruitEntityStub.fruitEntityCreate();
        when(fruitRepository.save(Mockito.any(FruitEntity.class))).thenReturn(fruit);
        var result = fruitServiceImpl.save(fruit);
        assertNotNull(result);
    }

    @Test
    public void findByIdTest() throws Exception {
        FruitEntity fruit = FruitEntityStub.fruitEntityCreate();
        when(fruitRepository.findById(1)).thenReturn(Optional.ofNullable(fruit));
        var result = fruitServiceImpl.findById(1);
        assertNotNull(result);
    }

    @Test
    public void findAllTest() {
        List<FruitEntity> fruit = FruitEntityStub.fruitEntityCreateList();
        when(fruitRepository.findAll()).thenReturn(fruit);
        var result = fruitServiceImpl.findAll();
        assertNotNull(result);
    }

    @Test
    public void multiplyTest() throws Exception {
        FruitEntity fruit = FruitEntityStub.fruitEntityCreate();
        when(fruitRepository.findById(1)).thenReturn(Optional.ofNullable(fruit));
        double result = fruitServiceImpl.multiply(1);
        assertNotNull(result);
    }

    @Test
    public void divisionTest() throws Exception {
        FruitEntity fruit = FruitEntityStub.fruitEntityCreate();
        when(fruitRepository.findById(1)).thenReturn(Optional.ofNullable(fruit));
        double result = fruitServiceImpl.division(1);
        assertNotNull(result);
    }

    @Test(expected = Exception.class)
    public void validDescricaoExceptionTest() {
        FruitEntity fruit = new FruitEntity();
        fruit.setDescricao("");
        fruitServiceImpl.save(fruit);
    }

    @Test(expected = Exception.class)
    public void validValueAExceptionTest() {
        FruitEntity fruit = new FruitEntity();
        fruit.setDescricao("Banana");
        fruitServiceImpl.save(fruit);
    }

    @Test(expected = Exception.class)
    public void validValueBExceptionTest() {
        FruitEntity fruit = new FruitEntity();
        fruit.setDescricao("Banana");
        fruit.setValorA(10);
        fruitServiceImpl.save(fruit);
    }
}
