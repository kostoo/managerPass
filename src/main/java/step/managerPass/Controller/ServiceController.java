package step.managerPass.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import step.managerPass.Entity.ServiceEntity;
import step.managerPass.Service.ServiceEntityService;

import java.util.List;

@RestController()
@RequiredArgsConstructor
@RequestMapping(path = "/service")
public class ServiceController {

    final ServiceEntityService serviceEntityService;

    @RequestMapping(path = "/getAllservices", method = RequestMethod.GET)
    public ResponseEntity<List<ServiceEntity>> getServiceGetAllServices() {
        return serviceEntityService.getAllServices();
    }

    @RequestMapping(method = {RequestMethod.POST}, path = "/addService",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceEntity> postServiceAddService(@RequestBody ServiceEntity newServiceEntity) {
        return serviceEntityService.addService(newServiceEntity);
    }

    @RequestMapping(method = {RequestMethod.DELETE}, path = "/deleteService/{id}")
    public ResponseEntity<ServiceEntity> deleteServiceDeleteServiceId(@PathVariable Long id) {
        return serviceEntityService.deleteService(id);
    }

    @RequestMapping(method = {RequestMethod.PUT}, path = "/updateService/{id}")
    public ResponseEntity<ServiceEntity> putServiceUpdateServiceId(@RequestBody ServiceEntity newServiceEntity,
                                                                   @PathVariable Long id)
            throws Exception {
        return serviceEntityService.updateService(newServiceEntity, id);
    }
}

