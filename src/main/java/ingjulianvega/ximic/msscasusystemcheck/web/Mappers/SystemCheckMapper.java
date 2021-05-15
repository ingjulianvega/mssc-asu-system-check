package ingjulianvega.ximic.msscasusystemcheck.web.Mappers;


import ingjulianvega.ximic.events.UpdateSystemCheckEvent;
import ingjulianvega.ximic.msscasusystemcheck.domain.SystemCheckEntity;
import ingjulianvega.ximic.msscasusystemcheck.web.model.SystemCheck;
import ingjulianvega.ximic.msscasusystemcheck.web.model.SystemCheckDto;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(uses = DateMapper.class)
public interface SystemCheckMapper {
    SystemCheckDto systemCheckEntityToSystemCheckDto(SystemCheckEntity remissionEntity);

    SystemCheckEntity systemCheckDtoToSystemCheckEntity(SystemCheckDto remissionDto);

    ArrayList<SystemCheckDto> systemCheckEntityListToSystemCheckDtoList(List<SystemCheckEntity> remissionEntityList);

    SystemCheck updateSystemCheckEventToSystemCheck(UpdateSystemCheckEvent updateSystemCheckEvent);
}
