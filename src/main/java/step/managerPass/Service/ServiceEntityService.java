package step.managerPass.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import step.managerPass.Entity.ServiceEntity;
import step.managerPass.Repository.ServiceEntityRepository;


import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceEntityService {
    private final ServiceEntityRepository serviceEntityRepository;


    public ResponseEntity<List<ServiceEntity>> getAllServices() {
        try {

            List<ServiceEntity> services = new ArrayList<>(serviceEntityRepository.findAll());
            if (services.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(services, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<ServiceEntity> addService(@RequestBody ServiceEntity newService) {
        ServiceEntity service = serviceEntityRepository.save(newService);
        return new ResponseEntity<>(service, HttpStatus.CREATED);
    }

    public ResponseEntity<ServiceEntity> deleteService(@PathVariable Long id) {
        serviceEntityRepository.deleteById(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    public ResponseEntity<ServiceEntity> updateService(@RequestBody ServiceEntity newService, @PathVariable Long id) {
        serviceEntityRepository.findById(id).map(service -> {
            service.setName(newService.getName());
            service.setId_service(newService.getId_service());
            serviceEntityRepository.save(service);
            return new ResponseEntity<>(null, HttpStatus.OK);
        })
                .orElseGet(() -> {
                    newService.setId_service(id);
                    serviceEntityRepository.save(newService);
                    return new ResponseEntity(null, HttpStatus.CREATED);
                });
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
