package step.managerPass.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import step.managerPass.entity.UserEntity;
import step.managerPass.exception.NotFoundException;
import step.managerPass.repository.UserEntityRepository;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserEntityService {

    private final UserEntityRepository userEntityRepository;

    public ArrayList<UserEntity> getAllUser() {
        return userEntityRepository.findAll();
    }

    public ArrayList<UserEntity> getAllUserByLastName(String last_name) {
        return userEntityRepository.findAllByLastName(last_name);
    }

    public UserEntity deleteUserById(Long id) throws NotFoundException {
        UserEntity userEntity = userEntityRepository.findById(id)
                                                    .orElseThrow(() -> new NotFoundException("Пользователь" +
                                                    " с этим идентификатором " + id + " не найден"));

        userEntityRepository.deleteUserEntityByIdUser(userEntity.getIdUser());

        return userEntity;
    }

    public UserEntity getUserById(Long id_user) {
        return userEntityRepository.findUserEntityByIdUser(id_user);
    }

    public UserEntity addUser(UserEntity userEntity) {
        return userEntityRepository.save(userEntity);
    }

    public UserEntity updateUser(UserEntity userEntity) throws NotFoundException {
        Optional<UserEntity> optionalUserEntity = Optional.of(userEntityRepository
                .findById(userEntity.getIdUser())
                .orElseThrow(()-> new NotFoundException("Данного пользователя не существует "+ userEntity.getIdUser())));

        return userEntityRepository.save(userEntity);
    }
}
