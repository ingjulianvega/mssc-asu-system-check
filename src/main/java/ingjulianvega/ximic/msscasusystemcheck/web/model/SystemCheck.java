package ingjulianvega.ximic.msscasusystemcheck.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SystemCheck implements Serializable {

    static final long serialVersionUID = -911066147749287453L;

    private UUID visitId;
    private UUID systemId;
    private UUID symptomId;
    private UUID intensityId;
    private String observations;

}
