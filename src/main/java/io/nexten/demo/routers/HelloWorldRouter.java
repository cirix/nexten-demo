package io.nexten.demo.routers;

import io.nexten.demo.handlers.HelloWorldHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@Slf4j
public class HelloWorldRouter {
    @Bean
    RouterFunction<ServerResponse> router(HelloWorldHandler helloWorldHandler) {
        return RouterFunctions
                .route()
                .GET("/hello", helloWorldHandler::sayHello)
                .build();
    }
}
