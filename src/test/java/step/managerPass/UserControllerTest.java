package step.managerPass;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import step.managerPass.Controller.UserController;
import step.managerPass.Entity.UserEntity;
import step.managerPass.Repository.UserEntityRepository;
import step.managerPass.Service.UserEntityService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    UserEntityService userEntityService;

    @MockBean
    UserEntityRepository userEntityRepository;

    UserEntity userEntity = new UserEntity(1L, "test", "test");
    UserEntity userEntity1 = new UserEntity(2L, "test1", "test1");
    UserEntity userEntity2 = new UserEntity(3L, "test2", "test2");


    @Test
    public void getAllRecords_success() throws Exception {

        List<UserEntity> users = new ArrayList<>(Arrays.asList(userEntity, userEntity1, userEntity2));
        Mockito.when(userEntityRepository.findAll()).thenReturn(users);
        Mockito.when(userEntityService.getAllUser()).thenReturn(users);

        mockMvc.perform(get("/getAllUser")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(3))
                );
    }

    @Test
    public void getAllTest_success() throws Exception {

        List<UserEntity> users = new ArrayList<>(Arrays.asList(userEntity, userEntity1, userEntity2));

        Mockito.when(userEntityRepository.findAll()).thenReturn(users);
        Mockito.when(userEntityService.getAllUser()).thenReturn(users);

        mockMvc.perform(get("/getAllTest")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(3))
                );
    }

    @Test
    public void getUserById_success() throws Exception {

        Mockito.when(userEntityRepository.findUserEntityByIdUser(userEntity.getIdUser())).thenReturn(userEntity);
        Mockito.when(userEntityService.getUserById(userEntity.getIdUser())).thenReturn(userEntity);

        mockMvc.perform(get("/getUserById/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.notNullValue())
                );
    }

    @Test
    public void getTest_success() throws Exception {

        mockMvc.perform(get("/getTest"))
                .andExpect(status().isOk()
                );
    }

    @Test
    public void createUser_success() throws Exception {

        UserEntity userEntityCreate = UserEntity.builder()
                .name("create")
                .lastName("test")
                .build();

        Mockito.when(userEntityRepository.save(userEntityCreate)).thenReturn(userEntityCreate);
        Mockito.when(userEntityService.addUser(userEntityCreate)).thenReturn(userEntityCreate);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/addUser")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(userEntityCreate));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.name", is("create")));
    }

    @Test
    public void updateUserEntity_success() throws Exception {

        UserEntity updatedRecord = UserEntity.builder()
                .idUser(2L)
                .name("test")
                .lastName("test2")
                .build();

        Mockito.when(userEntityRepository.findUserEntityByIdUser(userEntity.getIdUser())).thenReturn(userEntity);
        Mockito.when(userEntityRepository.save(updatedRecord)).thenReturn(updatedRecord);

        Mockito.when(userEntityService.getUserById(userEntity.getIdUser())).thenReturn(userEntity);
        Mockito.when(userEntityService.addUser(updatedRecord)).thenReturn(updatedRecord);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/addUser")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(updatedRecord));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.name", is("test")));
    }
}
