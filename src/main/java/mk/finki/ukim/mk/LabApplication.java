package mk.finki.ukim.mk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;


import javax.persistence.Basic;

@SpringBootApplication
@ServletComponentScan
public class LabApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabApplication.class, args);
    }

    /*@Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(10);
    }*/

}
