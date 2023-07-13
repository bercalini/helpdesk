package com.br.bercalini.helpdesk.config;

import com.br.bercalini.helpdesk.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import lombok.extern.slf4j.Slf4j;
@Configuration
@Profile("test")
@Slf4j
public class TestConfig {

    @Autowired
    private DBService dbService;

    @Bean
    public void instanciaDB() {
        log.info("INSTANCIA DO BANCO H2 INICIADO.....");
        dbService.instanciaDB();
    }
}
