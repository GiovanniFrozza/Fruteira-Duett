package com.duett.back.stub;

import com.duett.back.entity.FruitEntity;

import java.util.ArrayList;
import java.util.List;

public class FruitEntityStub {
    public static FruitEntity fruitEntityCreate(){
        return FruitEntity.builder()
                .id(1)
                .descricao("Banana")
                .valorA(10)
                .valorB(5)
            .build();
    }

    public static List<FruitEntity> fruitEntityCreateList(){
        List<FruitEntity> fruitEntityList = new ArrayList<>();

        fruitEntityList.add(FruitEntity.builder()
                .id(1)
                .descricao("Banana")
                .valorA(10)
                .valorB(5)
            .build());
        fruitEntityList.add(FruitEntity.builder()
                .id(1)
                .descricao("Apple")
                .valorA(100)
                .valorB(20)
            .build());

        return fruitEntityList;
    }
}
