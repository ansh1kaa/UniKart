package io.github.ansh1kaa.unikart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class UnikartApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(UnikartApplication.class, args);
    }

}

