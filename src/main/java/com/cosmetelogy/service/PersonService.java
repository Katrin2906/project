package com.cosmetelogy.service;


import com.cosmetelogy.converter.PersonConverter;
import com.cosmetelogy.dto.PersonDto;
import com.cosmetelogy.entity.Person;
import com.cosmetelogy.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonService {
    private final PersonConverter personConverter;
    private final PersonRepository personRepository;

    public PersonService(PersonConverter personConverter, PersonRepository personRepository) {
        this.personConverter = personConverter;
        this.personRepository = personRepository;
    }

    @Transactional
    public PersonDto findById(Long id) {

        return personRepository.findById(id)
                .map(personConverter::toFront)
                .orElse(null);
    }

//    public List<PersonDto> findByOrderStatus(OrderStatus orderStatus) {
//        List<Person> byOrderStatus = personRepository.findByOrderStatus(orderStatus);
//        return byOrderStatus.stream()
//                .map(personConverter::toFront)
//                .toList();
//    }

//    public List<PersonDto> findAllByProcedureName(ProcedureName procedureName) {
//        List<Person> allByProcedureName = personRepository.findAllByProcedureName(procedureName);
//        return allByProcedureName.stream()
//                .map(personConverter::toFront)
//                .toList();
//    }

//    public List<PersonDto> findAllByVisitDate(Visit visitDate) {
//        List<Person> allByVisit = personRepository.findAllByVisitDate(visitDate);
//        return allByVisit.stream()
//                .map(personConverter::toFront)
//                .toList();
//    }

    public Long save(PersonDto dto) {
        Person person = personConverter.toLocal(dto);
        return personRepository.save(person).getId();
    }

//    public List<PersonDto> findAllByNotePregnant(Note pregnant) {
//        List<Person> byNotePregnant = personRepository.findByNotePregnant(pregnant);
//        return byNotePregnant.stream()
//                .map(personConverter::toFront)
//                .toList();
//    }

}
