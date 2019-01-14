package web.config;

import db.ShopFactory;
import db.dbInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public dbInterface service(){
        return new ShopFactory().getType("JPA");
    }
}
