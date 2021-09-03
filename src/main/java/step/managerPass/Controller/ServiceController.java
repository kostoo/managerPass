package step.managerPass.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import step.managerPass.Entity.Service;
import step.managerPass.Repository.ServiceRepository;
import step.managerPass.Service.ServiceService;

import java.util.ArrayList;
import java.util.List;

@RestController()
public class ServiceController {
    final ServiceService serviceService;

    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }


    @RequestMapping(path = "/services", method = RequestMethod.GET)
    public ResponseEntity<List<Service>> getAllServices() {
        return serviceService.getAllServices();
    }

    @RequestMapping(method = {RequestMethod.POST}, path = "/addService",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Service> addService(@RequestBody Service newService) {
        return serviceService.addService(newService);
    }

    @RequestMapping(method = {RequestMethod.DELETE}, path = "/deleteService/{id}")
    public ResponseEntity<Service> deleteService(@PathVariable Integer id) {
        return serviceService.deleteService(id);
    }

    @RequestMapping(method = {RequestMethod.PUT}, path = "/updateService/{id}")
    public ResponseEntity<Service> updateService(@RequestBody Service newService, @PathVariable Long id) {
        return serviceService.updateService(newService, id);
    }
}

