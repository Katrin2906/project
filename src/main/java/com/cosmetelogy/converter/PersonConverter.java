package com.cosmetelogy.converter;

import com.cosmetelogy.dto.NoteDto;
import com.cosmetelogy.dto.OrderDto;
import com.cosmetelogy.dto.PersonDto;
import com.cosmetelogy.dto.VisitDto;
import com.cosmetelogy.entity.Note;
import com.cosmetelogy.entity.Order;
import com.cosmetelogy.entity.Person;
import com.cosmetelogy.entity.Visit;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonConverter {
    private final OrderConverter orderConverter;
    private final VisitConverter visitConverter;
    private final NoteConverter noteConverter;

    public PersonConverter(OrderConverter orderConverter, VisitConverter visitConverter, NoteConverter noteConverter) {
        this.orderConverter = orderConverter;
        this.visitConverter = visitConverter;
        this.noteConverter = noteConverter;
    }

    public PersonDto toFront(Person person) {
        NoteDto noteDto = noteConverter.toFront(person.getNote());
        List<OrderDto> orderDtos = orderConverter.toFront(person.getOrders());
        List<VisitDto> visitDtos = visitConverter.toFront(person.getVisits());

        return new PersonDto(person.getId(), person.getName(), person.getGender(), person.getAge(), noteDto, person.getNumber(), orderDtos, visitDtos);
    }

    public Person toLocal(PersonDto dto) {
        Note note = noteConverter.toLocal(dto.note());
        List<Visit> visits = visitConverter.toLocal(dto.visits());


        Person person = new Person();
        person.setId(dto.id());
        person.setAge(dto.age());
        person.setGender(dto.gender());
        person.setName(dto.name());
        person.setNumber(dto.number());
        person.setNote(note);
        person.setVisits(visits);


        List<Order> orders = orderConverter.toLocal(person, dto.orders());
        person.setOrders(orders);

        return person;
    }
}
