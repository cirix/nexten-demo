package io.nexten.demo.handlers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class HelloWorldHandler {
    public Mono<ServerResponse> sayHello(ServerRequest serverRequest) {
        log.info("Received request to say hello from ip:{}",serverRequest.remoteAddress().get().getAddress().getHostAddress());
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue("Hello World"));
    }
}
