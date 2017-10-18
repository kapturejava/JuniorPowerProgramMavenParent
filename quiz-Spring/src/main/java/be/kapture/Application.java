package be.kapture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by peeters.t on 17/10/2017.
 */
@SpringBootApplication
//@ComponentScan(basePackages = {"be.kapture"})
//@EnableJpaRepositories("be.kapture.repository")
//@EntityScan("be.kapture.entity")
public class Application {

    public static void main(String[] args){
//        new SpringApplicationBuilder().sources(Application.class).run(args);
        SpringApplication.run(Application.class,args);
    }

}
