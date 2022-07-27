package com.cosmetelogy.dto;

public record NoteDto(Long id,
                      String allergy,
                      String disease,
                      Boolean pregnancy,
                      String specialNotes) {
}
