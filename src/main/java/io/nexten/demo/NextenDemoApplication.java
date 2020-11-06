package io.nexten.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.dekorate.docker.annotation.DockerBuild;
import io.dekorate.kubernetes.annotation.KubernetesApplication;

@SpringBootApplication
@KubernetesApplication
public class NextenDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(NextenDemoApplication.class, args);
    }
}
