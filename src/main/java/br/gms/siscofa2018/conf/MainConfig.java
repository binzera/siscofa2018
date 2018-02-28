package br.gms.siscofa2018.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;


@Configuration
@ComponentScan(basePackages = "br.gms.siscofa2018")
@EnableScheduling
@Import(value = { JPAConfiguration.class, JPAProductionConfiguration.class}) //, SecurityConfig.class })
public class MainConfig {

}
