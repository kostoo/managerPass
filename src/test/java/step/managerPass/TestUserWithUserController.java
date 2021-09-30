package step.managerPass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import step.managerPass.entity.UserEntity;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestUserWithUserController {

    @LocalServerPort
    int randomServerPort;

    @Test
    public void testAddEmployeeUser_fail() {
        WebClient client = WebClient.builder()
                .baseUrl("http://localhost:" + randomServerPort)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiaWF0IjoxNjMyOTM0Nzc2LCJleHAiOjE2MzMwMjExNzZ9._1afpDdBJIPzCZ7WJbvBxbJMQlY7QBnONzHbkiQnnfoCFEV879hyn4s27a3XT8scyD3X6tPkTId2ED7jFTWklg")
                .build();

        UserEntity employee = UserEntity.builder()
                .name("nikita")
                .lastName("nesterov")
                .build();

        WebClient.ResponseSpec responseSpec = client.post()
                .uri("/user/addUser")
                .body(Mono.just(employee), UserEntity.class)
                .retrieve();

        ResponseEntity<Void> responseEntity = responseSpec.toBodilessEntity().block();
        assert responseEntity != null;
        Assertions.assertEquals(403, responseEntity.getStatusCodeValue());
    }

    @Test
    public void testGetEmployeesUser_fail() {
        WebClient client = WebClient.builder()
                .baseUrl("http://localhost:" + randomServerPort)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiaWF0IjoxNjMyOTM0Nzc2LCJleHAiOjE2MzMwMjExNzZ9._1afpDdBJIPzCZ7WJbvBxbJMQlY7QBnONzHbkiQnnfoCFEV879hyn4s27a3XT8scyD3X6tPkTId2ED7jFTWklg")
                .build();

        Mono<List<UserEntity>> responseSpec = client.get()
                .uri("/user/getAllUser")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<UserEntity>>() {
                });

        WebClient.ResponseSpec responseSpe = client.get()
                .uri("/user/getAllUser")
                .retrieve();

        ResponseEntity<Void> responseEntity = responseSpe.toBodilessEntity()
                .block();

        List<UserEntity> employees = responseSpec.block();

        Assertions.assertNotNull(employees);
        assert responseEntity != null;
        Assertions.assertEquals(403, responseEntity.getStatusCodeValue());
    }

    @Test
    public void testGetEmployeeByIdUser_fail() {
        WebClient client = WebClient.builder()
                .baseUrl("http://localhost:" + randomServerPort)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiaWF0IjoxNjMyOTM0Nzc2LCJleHAiOjE2MzMwMjExNzZ9._1afpDdBJIPzCZ7WJbvBxbJMQlY7QBnONzHbkiQnnfoCFEV879hyn4s27a3XT8scyD3X6tPkTId2ED7jFTWklg")
                .build();

        Mono<UserEntity> responceSpec = client.get()
                .uri("/user/getUser/1")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(UserEntity.class);

        Assertions.assertNotNull(responceSpec);
    }


}
