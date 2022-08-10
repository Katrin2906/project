package com.cosmetelogy.dto;

import com.cosmetelogy.entity.ProcedureName;

import java.math.BigDecimal;

public record ProcedureDto(Long id,
                           ProcedureName procedureName,
                           String description,
                           BigDecimal price) {
}
