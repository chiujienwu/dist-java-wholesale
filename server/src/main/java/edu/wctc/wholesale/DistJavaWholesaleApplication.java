package edu.wctc.wholesale;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class DistJavaWholesaleApplication {

	public static void main(String[] args) {
		SpringApplication.run(DistJavaWholesaleApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings (CorsRegistry registry){
				// address of Intellij's preview server
				registry.addMapping("/api/orders/**").allowedOrigins("http://localhost:63342");
			}
		};
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
