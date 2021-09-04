package step.managerPass;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import step.managerPass.Controller.ServiceController;
import step.managerPass.Entity.Service;
import step.managerPass.Service.ServiceService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ServiceController.class, excludeAutoConfiguration = SecurityAutoConfiguration.class)
public class ServiceControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServiceService serviceservice;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void whenPostService_thenCreateService() throws Exception {

    }
}
