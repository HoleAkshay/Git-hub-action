package io.nimbuspay;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;



import java.io.IOException;


@SpringBootApplication
public class ProAccountApplication {

	/*@Bean
	public Server grpcServer(HelloWorldServiceImpl helloWorldServiceImplService) {
		return ServerBuilder.forPort(9090)
				.addService(helloWorldServiceImplService)
				.build();
	}*/


	/*@Bean
	public Server grpcServer(HelloWorldServiceImpl helloWorldServiceImplService) {
		return ServerBuilder.forPort(9090)
				.addService(helloWorldServiceImplService)
				.build();
	}*/

	@Bean
	public Server grpcServer(HelloWorldServiceImpl helloWorldServiceImpl) {
		return ServerBuilder.forPort(9090)
				.addService(helloWorldServiceImpl)
				.build();
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		ConfigurableApplicationContext context = SpringApplication.run(ProAccountApplication.class, args);


		Server server = context.getBean(Server.class);
		server.start();
		server.awaitTermination();


	}






}
