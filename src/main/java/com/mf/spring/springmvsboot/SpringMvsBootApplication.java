package main.java.com.mf.spring.springmvsboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication (exclude = { SecurityAutoConfiguration.class })
public class SpringMvsBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMvsBootApplication.class, args);
    }

}
