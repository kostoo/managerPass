package step.managerPass.Controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import step.managerPass.Entity.ManagerPassEntity;
import step.managerPass.Exception.NotFoundException;
import step.managerPass.Service.ManagerPassEntityService;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/managerPass")
public class ManagerPassController {

    private final ManagerPassEntityService managerPassEntityService;

    @PostMapping(path = "/addManagerPass")
    public ResponseEntity postManagerPassAddManagerPass(@RequestBody ManagerPassEntity managerPassEntity) {

        managerPassEntityService.addManagerPass(managerPassEntity);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(path = "/getAllManagerPass")
    public ResponseEntity getManagerPassGetAllManagerPass() throws NotFoundException {

        List<ManagerPassEntity> managerPassEntities = managerPassEntityService.getAllManagerPass();

        return new ResponseEntity(managerPassEntities, HttpStatus.OK);

    }

    @PutMapping(path = "/updateManagerPass")
    public void putManagerPassUpdateManagerPass() {

    }

    @DeleteMapping(path = "/deleteManagerPass")
    public void deleteManagerPassDeleteManagerPass() {

    }

}
