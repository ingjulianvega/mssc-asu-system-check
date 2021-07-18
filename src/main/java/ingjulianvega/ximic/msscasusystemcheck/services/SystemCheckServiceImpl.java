package ingjulianvega.ximic.msscasusystemcheck.services;


import ingjulianvega.ximic.msscasusystemcheck.configuration.ErrorCodeMessages;
import ingjulianvega.ximic.msscasusystemcheck.domain.SystemCheckEntity;
import ingjulianvega.ximic.msscasusystemcheck.domain.repositories.SystemCheckRepository;
import ingjulianvega.ximic.msscasusystemcheck.exception.SystemCheckException;
import ingjulianvega.ximic.msscasusystemcheck.web.Mappers.SystemCheckMapper;
import ingjulianvega.ximic.msscasusystemcheck.web.model.SystemCheck;
import ingjulianvega.ximic.msscasusystemcheck.web.model.SystemCheckDto;
import ingjulianvega.ximic.msscasusystemcheck.web.model.SystemCheckList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Service
public class SystemCheckServiceImpl implements SystemCheckService {

    private final SystemCheckRepository systemCheckRepository;
    private final SystemCheckMapper systemCheckMapper;

    @Cacheable(cacheNames = "systemCheckListCache")
    @Override
    public SystemCheckList get() {
        log.debug("get()...");
        return SystemCheckList
                .builder()
                .systemCheckDtoList(systemCheckMapper.systemCheckEntityListToSystemCheckDtoList(systemCheckRepository.findAll()))
                .build();
    }

    @Cacheable(cacheNames = "systemCheckCache")
    @Override
    public SystemCheckDto getById(UUID id) {
        log.debug("getById()...");
        return systemCheckMapper.systemCheckEntityToSystemCheckDto(
                systemCheckRepository.findById(id)
                        .orElseThrow(() -> SystemCheckException
                                .builder()
                                .httpStatus(HttpStatus.BAD_REQUEST)
                                .apiCode(ErrorCodeMessages.SYSTEM_CHECK_NOT_FOUND_API_CODE)
                                .error(ErrorCodeMessages.SYSTEM_CHECK_NOT_FOUND_ERROR)
                                .message(ErrorCodeMessages.SYSTEM_CHECK_NOT_FOUND_MESSAGE)
                                .solution(ErrorCodeMessages.SYSTEM_CHECK_NOT_FOUND_SOLUTION)
                                .build()));
    }

    @Override
    public SystemCheckList getByVisitId(UUID visitId) {
        log.debug("getByVisitId()...");
        return SystemCheckList
                .builder()
                .systemCheckDtoList(systemCheckMapper.systemCheckEntityListToSystemCheckDtoList(systemCheckRepository.findByVisitId(visitId)))
                .build();
    }

    @Override
    public void create(SystemCheck systemCheck) {
        log.debug("create()...");
        systemCheckMapper.systemCheckEntityToSystemCheckDto(
                systemCheckRepository.save(
                        systemCheckMapper.systemCheckDtoToSystemCheckEntity(
                                SystemCheckDto
                                        .builder()
                                        .visitId(systemCheck.getVisitId())
                                        .systemId(systemCheck.getSystemId())
                                        .symptomId(systemCheck.getSymptomId())
                                        .intensityId(systemCheck.getIntensityId())
                                        .observations(systemCheck.getObservations())
                                        .build())));
    }

    @Override
    public void updateById(UUID id, SystemCheck systemCheck) {
        log.debug("updateById...");
        SystemCheckEntity systemCheckEntity = systemCheckRepository.findById(id)
                .orElseThrow(() -> SystemCheckException
                        .builder()
                        .httpStatus(HttpStatus.BAD_REQUEST)
                        .apiCode(ErrorCodeMessages.SYSTEM_CHECK_NOT_FOUND_API_CODE)
                        .error(ErrorCodeMessages.SYSTEM_CHECK_NOT_FOUND_ERROR)
                        .message(ErrorCodeMessages.SYSTEM_CHECK_NOT_FOUND_MESSAGE)
                        .solution(ErrorCodeMessages.SYSTEM_CHECK_NOT_FOUND_SOLUTION)
                        .build());

        systemCheckEntity.setVisitId(systemCheck.getVisitId());
        systemCheckEntity.setSystemId(systemCheck.getSystemId());
        systemCheckEntity.setSymptomId(systemCheck.getSymptomId());
        systemCheckEntity.setIntensityId(systemCheck.getIntensityId());
        systemCheckEntity.setObservations(systemCheck.getObservations());

        systemCheckRepository.save(systemCheckEntity);
    }

    @Override
    public void deleteById(UUID id) {
        log.debug("deleteById...");
        systemCheckRepository.deleteById(id);
    }
}
