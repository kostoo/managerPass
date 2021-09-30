package step.managerPass.service.response;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import step.managerPass.entity.UserEntity;
import step.managerPass.exception.NotFoundException;
import step.managerPass.service.UserEntityService;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserEntityResponseService {

    private final UserEntityService userEntityService;

    public ResponseEntity<ArrayList<UserEntity>> getAllUser() {
        return new ResponseEntity<>(userEntityService.getAllUser(), HttpStatus.OK);
    }

    public ResponseEntity<UserEntity> deleteUserById(Long id) throws NotFoundException {
        return new ResponseEntity<>(userEntityService.deleteUserById(id), HttpStatus.OK);
    }

    public ResponseEntity<ArrayList<UserEntity>> getAllUserByLastName(String last_name) {
        return new ResponseEntity<>(userEntityService.getAllUserByLastName(last_name),HttpStatus.OK);
    }

    public ResponseEntity<UserEntity> getUserById(Long id_user) {
        return new ResponseEntity<>(userEntityService.getUserById(id_user), HttpStatus.OK);
    }

    public ResponseEntity<UserEntity> addUser(UserEntity userEntity) {
        return new ResponseEntity<>(userEntityService.addUser(userEntity), HttpStatus.OK);
    }

    public ResponseEntity<UserEntity> updateUser(UserEntity userEntity) throws NotFoundException {
        return new ResponseEntity<>(userEntityService.updateUser(userEntity), HttpStatus.OK);
    }
}
