package ingjulianvega.ximic.msscasusystemcheck.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class SystemCheckEntity extends BaseEntity {

    private UUID visitId;
    private UUID systemId;
    private UUID symptomId;
    private UUID intensityId;
    private String observations;
}
