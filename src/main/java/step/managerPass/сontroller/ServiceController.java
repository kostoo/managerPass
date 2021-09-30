package step.managerPass.сontroller;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import step.managerPass.entity.ServiceEntity;
import step.managerPass.service.ServiceEntityService;
import step.managerPass.service.response.ServiceEntityResponseService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/service")
public class ServiceController {

    private final ServiceEntityResponseService serviceEntityService;

    @GetMapping(path = "/getAllServices",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<ArrayList<ServiceEntity>> getServiceGetAllServices() {
        return serviceEntityService.getAllServices();
    }

    @PostMapping(path = "/addService",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<ServiceEntity> postServiceAddService(@RequestBody ServiceEntity newServiceEntity) {
        return serviceEntityService.addService(newServiceEntity);
    }

    @DeleteMapping(path = "/deleteService/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ServiceEntity> deleteServiceDeleteServiceId(@PathVariable Long id) throws NotFoundException {
        return serviceEntityService.deleteService(id);
    }

    @PutMapping(path = "/updateService",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ServiceEntity> putServiceUpdateServiceId(@RequestBody ServiceEntity newServiceEntity)
            throws Exception {
        return serviceEntityService.updateService(newServiceEntity);
    }

}

