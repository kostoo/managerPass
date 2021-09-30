package step.managerPass.service.response;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import step.managerPass.entity.ManagerPassEntity;
import step.managerPass.exception.NotFoundException;
import step.managerPass.service.ManagerPassEntityService;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class ManagerPassEntityResponseService {

    private final ManagerPassEntityService managerPassEntityService;

    public ResponseEntity<ArrayList<ManagerPassEntity>> getAllManagerPass() throws NotFoundException {
        return new ResponseEntity<>(managerPassEntityService.getAllManagerPass(), HttpStatus.OK);
    }

    public ResponseEntity<ManagerPassEntity> updateManagerPass(ManagerPassEntity managerPassEntity)
            throws NotFoundException {
        return new ResponseEntity<>(managerPassEntityService.updateManagerPass(managerPassEntity), HttpStatus.OK);
    }

    public ResponseEntity<ManagerPassEntity> addManagerPass(ManagerPassEntity managerPassEntity) {
        return new ResponseEntity<>(managerPassEntityService.addManagerPass(managerPassEntity), HttpStatus.OK);
    }

    public ResponseEntity<ManagerPassEntity> deleteManagerPass(Long id) {
        return new ResponseEntity<>(managerPassEntityService.deleteManagerPass(id), HttpStatus.OK);
    }

    public ResponseEntity<ArrayList<ManagerPassEntity>> findAllByStatusService() {
        return new ResponseEntity<>(managerPassEntityService.findAllByStatusService(), HttpStatus.OK);
    }
    public ResponseEntity<ArrayList<ManagerPassEntity>> findAllByStatusSecret() {
        return new ResponseEntity<>(managerPassEntityService.findAllByStatusSecret(), HttpStatus.OK);
    }
}
