package ingjulianvega.ximic.msscasusystemcheck.bootstrap;

import ingjulianvega.ximic.msscasusystemcheck.domain.SystemCheckEntity;
import ingjulianvega.ximic.msscasusystemcheck.domain.repositories.SystemCheckRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class SystemCheckLoader implements CommandLineRunner {

    private final SystemCheckRepository systemCheckRepository;

    @Override
    public void run(String... args) throws Exception {
        if (systemCheckRepository.count() == 0) {
            loadSystemCheckObjects();
        }
    }

    private void loadSystemCheckObjects() {
        systemCheckRepository.saveAll(Arrays.asList(
                SystemCheckEntity.builder()
                        .visitId(UUID.randomUUID())
                        .systemId(UUID.randomUUID())
                        .symptomId(UUID.randomUUID())
                        .intensityId(UUID.randomUUID())
                        .observations("observación").build(),
                SystemCheckEntity.builder()
                        .visitId(UUID.randomUUID())
                        .systemId(UUID.randomUUID())
                        .symptomId(UUID.randomUUID())
                        .intensityId(UUID.randomUUID())
                        .observations("observación").build(),
                SystemCheckEntity.builder()
                        .visitId(UUID.randomUUID())
                        .systemId(UUID.randomUUID())
                        .symptomId(UUID.randomUUID())
                        .intensityId(UUID.randomUUID())
                        .observations("observación").build(),
                SystemCheckEntity.builder()
                        .visitId(UUID.randomUUID())
                        .systemId(UUID.randomUUID())
                        .symptomId(UUID.randomUUID())
                        .intensityId(UUID.randomUUID())
                        .observations("observación").build(),
                SystemCheckEntity.builder()
                        .visitId(UUID.randomUUID())
                        .systemId(UUID.randomUUID())
                        .symptomId(UUID.randomUUID())
                        .intensityId(UUID.randomUUID())
                        .observations("observación").build()
        ));
    }
}