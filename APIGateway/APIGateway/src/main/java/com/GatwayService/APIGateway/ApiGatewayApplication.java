package com.GatwayService.APIGateway;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	// @Bean
	// public Customizer<Resilience4JCircuitBreakerFactory> defaultCustumizer() {
	// return factory -> factory.configureDefault(
	// id -> new Resilience4JConfigBuilder(id)
	// .circuitBreakerConfig(CircuitBreakerConfig.ofDefaults()).build());
	// }

}
