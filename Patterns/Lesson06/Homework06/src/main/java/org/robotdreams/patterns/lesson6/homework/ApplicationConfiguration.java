package org.robotdreams.patterns.lesson6.homework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
    // registration, option #1
    @Bean
    public DieselEngine dieselEngine() {
        return new DieselEngine();
    }

    @Bean
    public Foo foo() {
        return new Foo(bar());
    }
    @Bean
    public Bar bar() {
        return new Bar();
    }
}
