package ingjulianvega.ximic.msscasusystemcheck.listener;

import ingjulianvega.ximic.events.UpdateSystemCheckEvent;
import ingjulianvega.ximic.msscasusystemcheck.configuration.JmsConfig;
import ingjulianvega.ximic.msscasusystemcheck.services.SystemCheckService;
import ingjulianvega.ximic.msscasusystemcheck.web.Mappers.SystemCheckMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class UpdateSystemCheckListener {

    private final SystemCheckService systemCheckService;
    private final SystemCheckMapper systemCheckMapper;

    @JmsListener(destination = JmsConfig.UPDATE_SYSTEM_CHECK_QUEUE)
    public void listen(UpdateSystemCheckEvent updateSystemCheckEvent){
        log.debug("Got UpdateSystemCheckEvent " + updateSystemCheckEvent.toString());
        systemCheckService.create(systemCheckMapper.updateSystemCheckEventToSystemCheck(updateSystemCheckEvent));
    }
}
