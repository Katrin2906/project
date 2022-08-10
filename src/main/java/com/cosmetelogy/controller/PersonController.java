package com.cosmetelogy.controller;

import com.cosmetelogy.dto.PersonDto;
import com.cosmetelogy.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/save")
    public Long save(@RequestBody PersonDto dto) {
        return personService.save(dto);
    }

    @GetMapping("/{id}")
    public PersonDto findById(@PathVariable Long id) {
        return personService.findById(id);
    }

//    @GetMapping("/status/{orderStatus}")
//    public List<PersonDto> findByOrderStatus(@PathVariable OrderStatus orderStatus) {
//        return personService.findByOrderStatus(orderStatus);
//    }

//    @GetMapping("/date")
//    public List<PersonDto> findAllByVisitDate(@RequestParam List<Long> ids) {
//        return personService.findAllByVisitDate(ids);
//    }

    @GetMapping("/order/{order_id}")
    public PersonDto findByOrderId(@PathVariable Long id) {
        return personService.findById(id);
    }

//    @GetMapping("/name/{procedure_name}")
//    public List<PersonDto> findAllByProcedureName(@PathVariable ProcedureName procedureName) {
//        return personService.findAllByProcedureName(procedureName);
//    }

//    @GetMapping("/note{pregnant}")
//    public List<PersonDto> findAllByNotePregnant(@PathVariable List<Long> ids) {
//        return personService.findAllByNotePregnant(ids);
//    }


}

