package ingjulianvega.ximic.msscasusystemcheck.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SystemCheckList implements Serializable {

    static final long serialVersionUID = -3151594799351115903L;

    public ArrayList<SystemCheckDto> systemCheckDtoList;
}
