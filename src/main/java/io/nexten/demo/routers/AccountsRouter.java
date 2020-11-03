package io.nexten.demo.routers;

import io.nexten.demo.handlers.AccountsHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@Slf4j
public class AccountsRouter {

    @Bean
    public RouterFunction<ServerResponse> manageAccounts(AccountsHandler accountsHandler) {
        log.debug("Starting the debug session for class: {}",this.getClass().getName());
        return
                RouterFunctions.route()
                .GET("/accounts", accountsHandler::getAllAccounts)
                .build();
    }
}
