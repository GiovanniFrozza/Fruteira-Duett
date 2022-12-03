package com.duett.back;

import com.duett.back.entity.FruitEntity;
import com.duett.back.service.FruitService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile("!unit-test")
@RequiredArgsConstructor
public class CommandLineAppStartupRunner implements CommandLineRunner {
    private final FruitService fruitService;

    @Override
    public void run(String... args) {
        log.info("Começou a popular");

        fruitService.save(FruitEntity.builder()
                    .descricao("Banana")
                    .valorA(10)
                    .valorB(10)
                .build());

        fruitService.save(FruitEntity.builder()
                    .descricao("Maca")
                    .valorA(4)
                    .valorB(8)
                .build());

        fruitService.save(FruitEntity.builder()
                .descricao("Uva")
                .valorA(2)
                .valorB(80)
            .build());

        fruitService.save(FruitEntity.builder()
                .descricao("Abacaxi")
                .valorA(80)
                .valorB(2)
            .build());

        log.info("Terminou de popular");
    }

}