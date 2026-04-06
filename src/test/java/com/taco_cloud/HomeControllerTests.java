package com.taco_cloud;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.client.RestTestClient;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureRestTestClient
public class HomeControllerTests {

    @Autowired
    private RestTestClient restClient;

    @Test
    public void testHomePage() throws Exception {
        restClient.get()
                .uri("/")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .value(body -> assertThat(body).contains("Welcome to..."));
    }
}