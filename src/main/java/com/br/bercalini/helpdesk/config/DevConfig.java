package com.br.bercalini.helpdesk.config;

import com.br.bercalini.helpdesk.service.DBService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
@Slf4j
public class DevConfig {

    @Autowired
    private DBService dbService;
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String value;

    @Bean
    public void instanciarDB() {
        if(value.equals("create")) {
            log.info("PERFIL DEV INSTANCIA DO BANCO H2 INICIADO.....");
            dbService.instanciaDB();
        }
    }

}
