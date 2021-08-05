package ingjulianvega.ximic.msscasusystemcheck.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SystemCheck implements Serializable {

    static final long serialVersionUID = -911066147749287453L;

    @NotNull
    private UUID visitId;
    @NotNull
    private UUID systemId;
    @NotNull
    private UUID symptomId;
    @NotNull
    private UUID intensityId;
    @NotBlank
    private String observations;

}
