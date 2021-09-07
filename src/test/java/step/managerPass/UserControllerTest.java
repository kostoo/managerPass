package step.managerPass;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import step.managerPass.Controller.UserController;
import step.managerPass.Entity.UserEntity;
import step.managerPass.Service.UserEntityService;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@WebMvcTest(value = UserController.class, excludeAutoConfiguration = SecurityAutoConfiguration.class)
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;
    @MockBean
    private UserEntityService userEntityService;

    UserEntity userEntity = new UserEntity(1L, "test", "test");
    UserEntity userEntity1 = new UserEntity(2L, "test1", "test1");
    UserEntity userEntity2 = new UserEntity(3L, "test2", "test2");

    @Test
    public void getAllRecords_success() throws Exception {

        List<UserEntity> users = new ArrayList<>(Arrays.asList(userEntity, userEntity1, userEntity2));

        Mockito.when(userEntityService.getAllUser()).thenReturn(users);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/user/getAllUser")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(3))
                );
    }

    @Test
    public void getUserById_success() throws Exception {

        Mockito.when(userEntityService.getUserById(userEntity.getId_user())).thenReturn(userEntity);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/user/getUserById/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.notNullValue())
                );
    }



}
