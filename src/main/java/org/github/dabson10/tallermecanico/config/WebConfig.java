package org.github.dabson10.tallermecanico.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Value("${app.cors.allowed-origin}")
    private String url;

   public void addCorsMapping(CorsRegistry registro){
       registro.addMapping("/**")
               .allowedOrigins(url)
               .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
               .allowedHeaders("*")
               .allowCredentials(true);
   }
}
