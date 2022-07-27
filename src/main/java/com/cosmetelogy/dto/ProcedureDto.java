package com.cosmetelogy.dto;

import com.cosmetelogy.entity.ProcedureName;

import java.math.BigDecimal;

public record ProcedureDto(Long id,
                           ProcedureName procedureName, /*todo ProcedureName replace with DTO*/
                           String description,
                           BigDecimal price) {
}
