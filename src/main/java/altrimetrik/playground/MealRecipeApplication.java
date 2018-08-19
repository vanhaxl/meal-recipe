package altrimetrik.playground;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//@EnableDiscoveryClient
@SpringBootApplication
public class MealRecipeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MealRecipeApplication.class, args);
    }
}