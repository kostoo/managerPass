package step.managerPass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    final
    ServiceRepository serviceRepository;


    public Controller(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }


    @RequestMapping(path = "/services", method = RequestMethod.GET)
    public ResponseEntity<List<Service>> getAllServices(@RequestParam(required = false) String service) {
        try {
            List<Service> services = new ArrayList<>();

            serviceRepository.findAll().forEach(services::add);
            if (services.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(services, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = {RequestMethod.POST}, path = "addService",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Service> addService(@RequestBody Service newService) {
        Service service = serviceRepository.save(newService);
        if (service == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(service, HttpStatus.CREATED);
        }
    }

    @RequestMapping(method = {RequestMethod.DELETE}, path = "deleteService/{id}")
    public ResponseEntity<Service> deleteService(@PathVariable Integer id) {
        serviceRepository.deleteById(id);
        return  new ResponseEntity <>(null, HttpStatus.OK);
    }
}

