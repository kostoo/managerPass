package step.managerPass.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import step.managerPass.Repository.ServiceRepository;


import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceService {
    private final ServiceRepository serviceRepository;

    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public ResponseEntity<List<step.managerPass.Entity.Service>> getAllServices() {
        try {
            List<step.managerPass.Entity.Service> services = new ArrayList<>();

            serviceRepository.findAll().forEach(services::add);
            if (services.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(services, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<step.managerPass.Entity.Service> addService(@RequestBody step.managerPass.Entity.Service newService) {
        step.managerPass.Entity.Service service = serviceRepository.save(newService);
        if (service == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(service, HttpStatus.CREATED);
        }
    }

    public ResponseEntity<step.managerPass.Entity.Service> deleteService(@PathVariable Integer id) {
        serviceRepository.deleteById(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    public ResponseEntity<step.managerPass.Entity.Service> updateService(@RequestBody step.managerPass.Entity.Service newService, @PathVariable Long id) {
        serviceRepository.findById(Math.toIntExact(id)).map(service -> {
            service.setName(newService.getName());
            service.setId_service(newService.getId_service());
            serviceRepository.save(service);
            return new ResponseEntity<>(null, HttpStatus.OK);
        })
                .orElseGet(() -> {
                    newService.setId_service(id);
                    serviceRepository.save(newService);
                    return new ResponseEntity(null, HttpStatus.CREATED);
                });
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
