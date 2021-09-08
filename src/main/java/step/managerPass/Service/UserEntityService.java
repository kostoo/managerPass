package step.managerPass.Service;

import com.sun.jdi.request.InvalidRequestStateException;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.HttpClientErrorException;
import step.managerPass.Entity.UserEntity;
import step.managerPass.Repository.UserEntityRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserEntityService {
    private final UserEntityRepository userEntityRepository;

    public List<UserEntity> getAllUser() {
        return userEntityRepository.findAll();
    }

    public List<UserEntity> getAllUserByLastName(String last_name) {
        return userEntityRepository.findAllByLastName(last_name);
    }

    public Boolean deleteUserById(Long id) throws NotFoundException {
        Boolean present = userEntityRepository.findById(id).isPresent();
        if (!present) {
            throw new NotFoundException("Пользователь с этим идентификатором " + id + " не найден");
        }
        return Boolean.TRUE;
    }

    public UserEntity getUserById(Long id_user) {

        return userEntityRepository.findUserEntityByIdUser(id_user);
    }

    public UserEntity addUser(UserEntity userEntity) {

        return userEntityRepository.save(userEntity);
    }

    public UserEntity updateUser(UserEntity userEntity) throws NotFoundException {

        if (userEntity == null || userEntity.getIdUser() == null) {
            throw new InvalidRequestStateException("Объект или идентификатор не может быть пустым");
        }

        Optional<UserEntity> optionalUserEntity = userEntityRepository.findById(userEntity.getIdUser());
        if (optionalUserEntity.isPresent()) {
            throw new NotFoundException("Невозможно найти пользователя " + userEntity.getIdUser() + "с таким идентификатором");
        }
        UserEntity existingUserEntity = optionalUserEntity.get();
        existingUserEntity.setName(userEntity.getName());
        existingUserEntity.setLastName(userEntity.getLastName());

        return userEntityRepository.save(existingUserEntity);
    }
}
