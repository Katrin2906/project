package com.cosmetelogy.service;

import com.cosmetelogy.converter.PersonConverter;
import com.cosmetelogy.dto.PersonDto;
import com.cosmetelogy.entity.Person;
import com.cosmetelogy.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PersonServiceTest {
    private final PersonConverter personConverter = mock(PersonConverter.class);
    private final PersonRepository personRepository = mock(PersonRepository.class);

    private final PersonService subject = new PersonService(personConverter, personRepository);

    @Test
    void save() {
        //Given
        PersonDto personDto = new PersonDto(1L, "Zina", "f", 22, null, "121212", null, null);
        Person expected = new Person();
        when(personConverter.toLocal(any())).thenReturn(expected);
        when(personRepository.save(personConverter.toLocal(any()))).thenReturn(expected);
        //When
        String actual = subject.save(personDto).toString();
        //Then
        Assertions.assertTrue(actual.contains(expected.toString()));
    }

}