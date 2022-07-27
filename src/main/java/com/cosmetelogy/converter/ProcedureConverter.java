package com.cosmetelogy.converter;

import com.cosmetelogy.dto.ProcedureDto;
import com.cosmetelogy.entity.Procedure;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProcedureConverter {
    public Procedure toLocal(ProcedureDto dto) {
        if (dto == null) {
            return null;
        }

        Procedure procedure = new Procedure();

        procedure.setId(dto.id());
        procedure.setPrice(dto.price());
        procedure.setProcedureName(dto.procedureName());
        procedure.setDescription(dto.description());

        return procedure;
    }

    public ProcedureDto toFront(Procedure procedure) {
        if (procedure == null) {
            return null;
        }

        return new ProcedureDto(procedure.getId(), procedure.getProcedureName(), procedure.getDescription(), procedure.getPrice());
    }

    public List<Procedure> toLocal(List<ProcedureDto> procedureDtos) {
        if (procedureDtos == null) {
            return null;
        }

        return procedureDtos.stream()
                .map(this::toLocal)
                .toList();
    }

    public List<ProcedureDto> toFront(List<Procedure> procedures) {
        if (procedures == null) {
            return null;
        }

        return procedures.stream()
                .map(this::toFront)
                .toList();
    }
}
