package step.managerPass.service.response;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import step.managerPass.entity.ServiceEntity;
import step.managerPass.service.ServiceEntityService;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class ServiceEntityResponseService {
    private final ServiceEntityService serviceEntityService;

    public ResponseEntity<ArrayList<ServiceEntity>> getAllServices() {
        return new ResponseEntity<>(serviceEntityService.getAllServices(), HttpStatus.OK);
    }

    public ResponseEntity<ServiceEntity> addService(ServiceEntity newService) {
        return new ResponseEntity<>(serviceEntityService.addService(newService), HttpStatus.OK);
    }

    public ResponseEntity<ServiceEntity> deleteService(Long id) throws NotFoundException {
        return new ResponseEntity<>(serviceEntityService.deleteService(id), HttpStatus.OK);
    }

    public ResponseEntity<ServiceEntity> updateService(ServiceEntity serviceEntity) throws NotFoundException {
        return new ResponseEntity<>(serviceEntityService.updateService(serviceEntity), HttpStatus.OK);
    }
}
