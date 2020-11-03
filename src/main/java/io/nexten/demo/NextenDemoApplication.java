package io.nexten.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.dekorate.docker.annotation.DockerBuild;
import io.dekorate.kubernetes.annotation.KubernetesApplication;

@SpringBootApplication
@KubernetesApplication 
@DockerBuild(autoBuildEnabled = true, autoPushEnabled = true ,version = "1.0",
        dockerFile = "Dockerfile", name = "nexten-demo", registry = "dockerhub.io")
public class NextenDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(NextenDemoApplication.class, args);
    }
}
