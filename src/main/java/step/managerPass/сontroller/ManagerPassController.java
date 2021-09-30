package step.managerPass.сontroller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import step.managerPass.entity.ManagerPassEntity;
import step.managerPass.exception.NotFoundException;
import step.managerPass.service.ManagerPassEntityService;
import step.managerPass.service.response.ManagerPassEntityResponseService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/managerPass")
public class ManagerPassController {

    private final ManagerPassEntityResponseService managerPassEntityResponseService;

    @PostMapping(path = "/addManagerPass")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<ManagerPassEntity> postManagerPassAddManagerPass
            (@RequestBody ManagerPassEntity managerPassEntity) {
        return managerPassEntityResponseService.addManagerPass(managerPassEntity);
    }

    @GetMapping(path = "/getAllManagerPass")
    @PreAuthorize(value = "hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<ArrayList<ManagerPassEntity>> getManagerPassGetAllManagerPass() throws NotFoundException {
        return managerPassEntityResponseService.getAllManagerPass();
    }

    @PutMapping(path = "/updateManagerPass")
    @PreAuthorize(value = "hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<ManagerPassEntity> putManagerPassUpdateManagerPass
            (@RequestBody ManagerPassEntity managerPassEntity) {
        return managerPassEntityResponseService.updateManagerPass(managerPassEntity);
    }

    @DeleteMapping(path = "/deleteManagerPass")
    @PreAuthorize(value = "hasRole('ADMIN')")
    public ResponseEntity<ManagerPassEntity> deleteManagerPassDeleteManagerPass
            (@PathVariable Long idManagerPass) {
        return managerPassEntityResponseService.deleteManagerPass(idManagerPass);
    }

    @GetMapping(path = "/getManagerPassesService")
    @PreAuthorize(value = "hasRole('ADMIN')")
    public ResponseEntity<ArrayList<ManagerPassEntity>> getManagerPassGetAllManagerPassService() {
        return managerPassEntityResponseService.findAllByStatusService();
    }
    @GetMapping(path = "/getManagerPassesSecret")
    @PreAuthorize(value = "hasRole('ADMIN')")
    public ResponseEntity<ArrayList<ManagerPassEntity>> getManagerPassGetAllManagerPassSecret() {
        return managerPassEntityResponseService.findAllByStatusSecret();
    }
}
