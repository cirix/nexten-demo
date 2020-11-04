package io.nexten.demo.handlers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@Slf4j
public class AccountsHandler {

    public Mono<ServerResponse> getAllAccounts(ServerRequest serverRequest) {
        log.info("Accepted request from ip:{}", serverRequest.remoteAddress().get().getAddress());
        List<String> accounts = new ArrayList<>();
        for (int i = 0; i < 100; i++)
            accounts.add(generateRandomString());
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .cookie(ResponseCookie.from("CUSTOM_COOKIE", "Some value").build())
                .body(BodyInserters.fromValue(accounts));
    }

    private String generateRandomString() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 24;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
