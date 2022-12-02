package com.duett.back.entity;

import com.duett.back.stub.FruitEntityStub;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class FruitEntityTest {
    @Test
    public void getterAndSetterTest() {
        FruitEntity fruit = new FruitEntity();

        fruit.setId(1);
        fruit.setDescricao("Abacaxi");
        fruit.setValorA(2);
        fruit.setValorB(3);

        assertNotNull(fruit.getId());
        assertNotNull(fruit.getDescricao());
        assertNotNull(fruit.getValorA());
        assertNotNull(fruit.getValorB());
    }

    @Test
    public void constructorTest() {
        FruitEntity fruitNoArgs = new FruitEntity();
        assertNotNull(fruitNoArgs);

        FruitEntity fruitWithArgs = FruitEntityStub.fruitEntityCreate();
        assertNotNull(fruitWithArgs);
    }

    @Test
    public void builderTest() {
        FruitEntity fruit = FruitEntity.builder()
                .id(1)
                .descricao("melao")
                .valorA(17)
                .valorB(26)
            .build();
        assertNotNull(fruit);
    }
}
