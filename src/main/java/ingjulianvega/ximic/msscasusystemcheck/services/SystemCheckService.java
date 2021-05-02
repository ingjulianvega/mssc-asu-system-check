package ingjulianvega.ximic.msscasusystemcheck.services;


import ingjulianvega.ximic.msscasusystemcheck.web.model.SystemCheck;
import ingjulianvega.ximic.msscasusystemcheck.web.model.SystemCheckDto;
import ingjulianvega.ximic.msscasusystemcheck.web.model.SystemCheckList;

import java.util.UUID;

public interface SystemCheckService {
    SystemCheckList get();

    SystemCheckDto getById(UUID id);

    SystemCheckList getByVisitId(UUID patientId);

    void create(SystemCheck systemCheck);

    void updateById(UUID id, SystemCheck systemCheck);

    void deleteById(UUID id);


}
