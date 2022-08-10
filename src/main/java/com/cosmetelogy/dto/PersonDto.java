package com.cosmetelogy.dto;

import java.util.List;

public record PersonDto(Long id,
                        String name,
                        String gender,
                        Integer age,
                        NoteDto note,
                        String number,
                        List<OrderDto> orders,
                        List<VisitDto> visitDtos) {
}
