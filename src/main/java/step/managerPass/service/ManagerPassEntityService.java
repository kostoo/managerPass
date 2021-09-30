package step.managerPass.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import step.managerPass.entity.ManagerPassEntity;
import step.managerPass.exception.NotFoundException;
import step.managerPass.repository.ManagerPassRepository;

import java.util.ArrayList;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ManagerPassEntityService {

    private final ManagerPassRepository managerPassRepository;

    public ArrayList<ManagerPassEntity> getAllManagerPass() throws NotFoundException {
        return managerPassRepository.findAll();
    }

    public ManagerPassEntity addManagerPass(ManagerPassEntity managerPassEntity) {
        return managerPassRepository.save(managerPassEntity);
    }

    public ManagerPassEntity updateManagerPass(ManagerPassEntity managerPassEntity) throws NotFoundException {
        Optional<ManagerPassEntity> optionalManagerPassEntity = Optional.of(managerPassRepository
                .findById(managerPassEntity.getId())
                .orElseThrow(() -> new NotFoundException(" невозможно  найти запись" +
                        " с этим идентификатором " + managerPassEntity.getId())));

        return managerPassRepository.save(optionalManagerPassEntity.get());
    }

    public ManagerPassEntity deleteManagerPass(Long id) {
        Optional<ManagerPassEntity> optionalManagerPassEntity = Optional.of(managerPassRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(" невозможно  найти запись" +
                        " с этим идентификатором " + id)));
        managerPassRepository.deleteById(id);
        return optionalManagerPassEntity.get();
    }

    public ArrayList<ManagerPassEntity> findAllByStatusService() {
        return managerPassRepository.findAllByStatusService();
    }

    public ArrayList<ManagerPassEntity> findAllByStatusSecret() {
        return managerPassRepository.findAllByStatusSecret();
    }
}
