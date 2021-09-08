package step.managerPass.Controller;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<List<ServiceEntity>> getServiceGetAllServices() throws NotFoundException {

        List<ServiceEntity> services = serviceEntityService.getAllServices();

        return new ResponseEntity<>(services, HttpStatus.OK);
    }

    @RequestMapping(method = {RequestMethod.POST}, path = "/addService",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceEntity> postServiceAddService(@RequestBody ServiceEntity newServiceEntity) {

        serviceEntityService.addService(newServiceEntity);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = {RequestMethod.DELETE}, path = "/deleteService/{id}")
    public ResponseEntity<ServiceEntity> deleteServiceDeleteServiceId(@PathVariable Long id) throws NotFoundException {

        serviceEntityService.deleteService(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = {RequestMethod.PUT}, path = "/updateService")
    public ResponseEntity<ServiceEntity> putServiceUpdateServiceId(@RequestBody ServiceEntity newServiceEntity)
            throws Exception {
        ServiceEntity serviceEntity = serviceEntityService.updateService(newServiceEntity);

        return new ResponseEntity<>(serviceEntity, HttpStatus.OK);
    }
}

