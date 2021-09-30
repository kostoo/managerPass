package step.managerPass;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestManagerPassAdminController {

    @LocalServerPort
    int randomServerPort;

    public void getAllManagerPass_success(){

    }
}
