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
import step.managerPass.payload.request.LoginRequest;

import java.util.List;
import java.util.Objects;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestUserWithAdminController {

    @LocalServerPort
    int randomServerPort;

    @Test
    public void postEmployeeAdmin_success() {
        WebClient client = WebClient.builder()
                .baseUrl("http://localhost:" + randomServerPort)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
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
        //Verify request succeed
        assert responseEntity != null;
    }

    @Test
    public void getEmployeesAdmin_success() {
        WebClient client = WebClient.builder()
                .baseUrl("http://localhost:" + randomServerPort)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTYzMjg2MzEwMSwiZXhwIjoxNjMyOTQ5NTAxfQ.Q665zGUjL37FwviA0nVSUiQoBDYVCbKzpk09cBHux-FeVNZeHrlXX_-GkAHF_GjA7mLZPLmqyqWbC1ZCe2w2dQ")
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
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    public void testGetEmployeeByIdAdmin_success() {
        WebClient client = WebClient.builder()
                .baseUrl("http://localhost:" + randomServerPort)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTYzMjg2MzEwMSwiZXhwIjoxNjMyOTQ5NTAxfQ.Q665zGUjL37FwviA0nVSUiQoBDYVCbKzpk09cBHux-FeVNZeHrlXX_-GkAHF_GjA7mLZPLmqyqWbC1ZCe2w2dQ")
                .build();

        WebClient.ResponseSpec responceSpec = client.get()
                .uri("/user/getUser/1")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve();

        Assertions.assertEquals(200, Objects.requireNonNull(responceSpec.toBodilessEntity().block()).getStatusCodeValue());
    }

    @Test
    public void testUpdateEmployeeByIdAdmin_success() {
        WebClient client = WebClient.builder()
                .baseUrl("http://localhost:" + randomServerPort)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTYzMjg2MzEwMSwiZXhwIjoxNjMyOTQ5NTAxfQ.Q665zGUjL37FwviA0nVSUiQoBDYVCbKzpk09cBHux-FeVNZeHrlXX_-GkAHF_GjA7mLZPLmqyqWbC1ZCe2w2dQ")
                .build();

        UserEntity employee = UserEntity.builder()
                .idUser(2L)
                .name("test")
                .lastName("test")
                .build();

        WebClient.ResponseSpec responseSpec = client.put()
                .uri("/user/updateUser")
                .body(Mono.just(employee), UserEntity.class)
                .retrieve();

        ResponseEntity<Void> responseEntity = responseSpec.toBodilessEntity().block();

        //Verify request succeed
        assert responseEntity != null;
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    public void testDeleteEmployeeByIdAdmin_success() {
        WebClient client = WebClient.builder()
                .baseUrl("http://localhost:" + randomServerPort)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTYzMjg2MzEwMSwiZXhwIjoxNjMyOTQ5NTAxfQ.Q665zGUjL37FwviA0nVSUiQoBDYVCbKzpk09cBHux-FeVNZeHrlXX_-GkAHF_GjA7mLZPLmqyqWbC1ZCe2w2dQ")
                .build();

        WebClient.ResponseSpec responseSpe = client.delete()
                .uri("/user/deleteUser/3")
                .retrieve();

        ResponseEntity<Void> responseEntity = responseSpe.toBodilessEntity()
                .block();

        assert responseEntity != null;
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
    }

}
