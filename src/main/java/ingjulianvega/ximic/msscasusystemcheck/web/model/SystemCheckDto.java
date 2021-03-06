package ingjulianvega.ximic.msscasusystemcheck.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SystemCheckDto implements Serializable {

    static final long serialVersionUID = 3702314803371689088L;

    private UUID id;
    private UUID visitId;
    private UUID systemId;
    private UUID symptomId;
    private UUID intensityId;
    private String observations;
    private OffsetDateTime createdDate;

}
