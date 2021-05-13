package ingjulianvega.ximic.msscasusystemcheck.listener;

import ingjulianvega.ximic.events.UpdateSystemCheckEvent;
import ingjulianvega.ximic.msscasusystemcheck.configuration.JmsConfig;
import ingjulianvega.ximic.msscasusystemcheck.services.SystemCheckService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class UpdateSystemCheckListener {

    private final SystemCheckService systemCheckService;

    @JmsListener(destination = JmsConfig.UPDATE_SYSTEM_CHECK_QUEUE)
    public void listen(UpdateSystemCheckEvent event){
        log.debug("Got updateSystemCheck " + event.toString());
        //visitService.create(event.getVisit());
    }
}
