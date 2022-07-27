package com.cosmetelogy.dto;

import java.util.List;

public record PersonDto(Long id,
                        String name,
                        String gender,
                        Integer age,
                        NoteDto noteDto,
                        String number,
                        List<OrderDto> orderDtos,
                        List<VisitDto> visitDtos) {
}
