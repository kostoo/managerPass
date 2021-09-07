package step.managerPass.Controller;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import step.managerPass.Entity.UserEntity;
import step.managerPass.Service.UserEntityService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(name = "/user")
@RequiredArgsConstructor
public class UserController {

    UserEntityService userService;

    @RequestMapping(path = "/getAllUser", method = RequestMethod.GET)
    public ResponseEntity<List<UserEntity>> getUserGetAll() {

        List<UserEntity> users = new ArrayList<>(userService.getAllUser());

        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }


    @RequestMapping(path = "/getUserByName/{lastName}", method = RequestMethod.GET)
    public ResponseEntity<List<UserEntity>> getUserByLastName(@PathVariable(value = "lastName") String lastName) {

        List<UserEntity> users = userService.getAllUserByLastName(lastName);

        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }


    @RequestMapping(path = "/deleteUser/{idUser}", method = RequestMethod.DELETE)
    public ResponseEntity<UserEntity> deleteUserById(@PathVariable(value = "idUser") Long id) throws NotFoundException {
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(path = "/getUser/{idUser}", method = RequestMethod.GET)
    public ResponseEntity getUserByIdUser(@PathVariable(value = "idUser") Long id_user) {

        Optional<UserEntity> user = Optional.of(userService.getUserById(id_user));

        return ResponseEntity.ok().body(user.get());
    }

    @RequestMapping(path = "/addUser", method = RequestMethod.POST)
    public ResponseEntity postAddUser(@RequestBody UserEntity userEntity) {

        userService.addUser(userEntity);

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(path = "/updateUser", method = RequestMethod.PUT)
    public ResponseEntity putUserUpdate(@RequestBody UserEntity userEntity) throws NotFoundException {

        userService.updateUser(userEntity);

        return new ResponseEntity(HttpStatus.OK);
    }

}