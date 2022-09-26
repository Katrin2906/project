package com.cosmetelogy.service;

import com.cosmetelogy.converter.PersonConverter;
import com.cosmetelogy.dto.PersonDto;
import com.cosmetelogy.entity.OrderStatus;
import com.cosmetelogy.entity.Person;
import com.cosmetelogy.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonService {
    private final PersonConverter personConverter;
    private final PersonRepository personRepository;

    public PersonService(PersonConverter personConverter, PersonRepository personRepository) {
        this.personConverter = personConverter;
        this.personRepository = personRepository;
    }


    public PersonDto findById(Long id) {

        return personRepository.findById(id)
                .map(personConverter::toFront)
                .orElse(null);
    }

    @Transactional
    public Long save(PersonDto dto) {
        Person person = personConverter.toLocal(dto);
        return personRepository.save(person).getId();
    }

    public List<PersonDto> findAllByName(String name) {
        List<Person> allByName = personRepository.findAllByName(name);

        return allByName.stream().map(personConverter::toFront).toList();
    }

    @Transactional
    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }

//    @Transactional
//    public void setAge(Integer age, Long id) {
//        personRepository.setAge(age, id);
//    }
//
//    @Transactional
//    public List<Person> findByOrderStatus(OrderStatus orderStatus, Long id) {
//        return personRepository.findByOrderStatus(orderStatus, id);
//    }
}
