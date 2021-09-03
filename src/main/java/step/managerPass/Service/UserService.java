package step.managerPass.Service;

import org.springframework.stereotype.Service;
import step.managerPass.Repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
