package com.cosmetelogy.converter;

import com.cosmetelogy.dto.NoteDto;
import com.cosmetelogy.entity.Note;
import org.springframework.stereotype.Component;

@Component
public class NoteConverter {
    public Note toLocal(NoteDto dto) {
        if (dto == null) {
            return null;
        }

        Note note = new Note();

        note.setAllergy(dto.allergy());
        //  note.setPerson(person);
        note.setId(dto.id());
        note.setDisease(dto.disease());
        note.setPregnancy(dto.pregnancy());
        note.setSpecialNotes(dto.specialNotes());

        return note;
    }

    public NoteDto toFront(Note note) {
        if (note == null) {
            return null;
        }

        return new NoteDto(note.getId(), note.getAllergy(), note.getDisease(), note.getPregnancy(), note.getSpecialNotes());
    }
}
