package com.cosmetelogy.converter;

import com.cosmetelogy.dto.ProcedureDto;
import com.cosmetelogy.dto.VisitDto;
import com.cosmetelogy.entity.Person;
import com.cosmetelogy.entity.Procedure;
import com.cosmetelogy.entity.Visit;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VisitConverter {

    private final ProcedureConverter procedureConverter;

    public VisitConverter(ProcedureConverter procedureConverter) {
        this.procedureConverter = procedureConverter;
    }

    public Visit toLocal(Person person, VisitDto dto) {
        if (dto == null) {
            return null;
        }

        Visit visit = new Visit();

        visit.setId(dto.id());
        // visit.setPerson(person);
        visit.setVisitDate(dto.visitDate());
        visit.setPerson(person);
        List<Procedure> procedures = procedureConverter.toLocal(dto.procedures());
        visit.setProcedures(procedures);

        return visit;
    }

    public List<Visit> toLocal(Person person, List<VisitDto> visitDtos) {
        if (visitDtos == null) {
            return null;
        }

        return visitDtos.stream()
                .map(visitDto -> toLocal(person, visitDto))
                .toList();
    }

    public List<VisitDto> toFront(List<Visit> visits) {
        if (visits == null) {
            return null;
        }

        return visits.stream()
                .map(this::toFront)
                .toList();
    }

    public VisitDto toFront(Visit visit) {
        if (visit == null) {
            return null;
        }
        List<ProcedureDto> procedureDtos = procedureConverter.toFront(visit.getProcedures());

        return new VisitDto(visit.getId(), visit.getVisitDate(), procedureDtos);
    }
}