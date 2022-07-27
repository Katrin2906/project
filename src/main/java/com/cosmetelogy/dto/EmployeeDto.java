package com.cosmetelogy.dto;

import java.util.List;

public record EmployeeDto(Long id,
                          String name,
                          List<ProcedureDto> procedureDtos) {
}

