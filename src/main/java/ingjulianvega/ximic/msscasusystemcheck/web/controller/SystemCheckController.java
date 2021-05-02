package ingjulianvega.ximic.msscasusystemcheck.web.controller;


import ingjulianvega.ximic.msscasusystemcheck.services.SystemCheckService;
import ingjulianvega.ximic.msscasusystemcheck.web.model.SystemCheck;
import ingjulianvega.ximic.msscasusystemcheck.web.model.SystemCheckDto;
import ingjulianvega.ximic.msscasusystemcheck.web.model.SystemCheckList;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class SystemCheckController implements SystemCheckI {

    private final SystemCheckService systemCheckService;

    @Override
    public ResponseEntity<SystemCheckList> get() {
        return new ResponseEntity<>(systemCheckService.get(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SystemCheckDto> getById(@NotNull UUID id) {
        return new ResponseEntity<>(systemCheckService.getById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SystemCheckList> getByVisittId(UUID visitId) {
        return new ResponseEntity<>(systemCheckService.getByVisitId(visitId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> create(@NotNull @Valid SystemCheck systemCheck) {
        systemCheckService.create(systemCheck);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> updateById(@NotNull UUID id, @NotNull @Valid SystemCheck systemCheck) {
        systemCheckService.updateById(id, systemCheck);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Void> deleteById(@NotNull UUID id) {
        systemCheckService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
