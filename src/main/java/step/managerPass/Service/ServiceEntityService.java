package step.managerPass.Service;

import com.sun.jdi.request.InvalidRequestStateException;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import step.managerPass.Entity.ServiceEntity;
import step.managerPass.Repository.ServiceEntityRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceEntityService {
    private final ServiceEntityRepository serviceEntityRepository;


    public List<ServiceEntity> getAllServices() throws NotFoundException {

        List<ServiceEntity> services = new ArrayList<>(serviceEntityRepository.findAll());

        if (services.isEmpty()) {
            throw new NotFoundException("Невозможно найти сервисы");
        }

        return services;
    }

    public ServiceEntity addService(ServiceEntity newService) {

        ServiceEntity service = serviceEntityRepository.save(newService);
        return service;
    }

    public void deleteService(Long id) throws NotFoundException {
        Optional<ServiceEntity> optionalServiceEntity = serviceEntityRepository.findById(id);
        if (optionalServiceEntity.isPresent()) {
            throw new NotFoundException("Невозможно найти сервис" + id + "с таким идентификатором");
        }
        serviceEntityRepository.deleteById(id);
    }

    public ServiceEntity updateService(ServiceEntity serviceEntity) throws NotFoundException {

        if (serviceEntity == null || serviceEntity.getId_service() == null) {
            throw new InvalidRequestStateException("Объект или идентификатор не может быть пустым");
        }

        Optional<ServiceEntity> optionalServiceEntity = serviceEntityRepository.findById(serviceEntity.getId_service());
        if (optionalServiceEntity.isPresent()) {
            throw new NotFoundException("Невозможно найти сервис" + serviceEntity.getId_service() + "с таким идентификатором");
        }
        ServiceEntity existingServiceEntity = optionalServiceEntity.get();
        existingServiceEntity.setName(serviceEntity.getName());
        existingServiceEntity.setComment(serviceEntity.getComment());

        return serviceEntityRepository.save(existingServiceEntity);
    }
}
