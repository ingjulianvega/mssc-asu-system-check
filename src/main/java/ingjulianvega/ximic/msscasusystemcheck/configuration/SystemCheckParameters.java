package ingjulianvega.ximic.msscasusystemcheck.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "system-check")
public class SystemCheckParameters {

    private String success;
    private String prefix;
    private Error error;
    private String channelId;

    @Getter
    @Setter
    public static class Error {
        private String general;
    }
}
