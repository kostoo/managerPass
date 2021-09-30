package step.managerPass.service;

import com.sun.jdi.request.InvalidRequestStateException;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import step.managerPass.entity.ManagerPassEntity;
import step.managerPass.entity.ServiceEntity;
import step.managerPass.repository.ServiceEntityRepository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceEntityService {
    private final ServiceEntityRepository serviceEntityRepository;

    public ArrayList<ServiceEntity> getAllServices() {
        return serviceEntityRepository.findAll();
    }

    public ServiceEntity addService(ServiceEntity newService) {
        return serviceEntityRepository.save(newService);
    }

    public ServiceEntity deleteService(Long id) throws NotFoundException {
        Optional<ServiceEntity> optionalServiceEntity = Optional.of(serviceEntityRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(" невозможно  найти запись с этим идентификатором " + id )));
        serviceEntityRepository.deleteById(id);
        return optionalServiceEntity.get();
    }

    public ServiceEntity updateService(ServiceEntity serviceEntity) throws NotFoundException {
        Optional<ServiceEntity> optionalServiceEntity = Optional.of(serviceEntityRepository
                .findById(serviceEntity.getId_service())
                .orElseThrow(() -> new NotFoundException(" невозможно  найти запись с этим идентификатором " )));

        return serviceEntityRepository.save(optionalServiceEntity.get());
    }
}
