package com.cosmetelogy.controller;

import com.cosmetelogy.dto.PersonDto;
import com.cosmetelogy.dto.ProductDto;
import com.cosmetelogy.service.PersonService;
import com.cosmetelogy.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final PersonService personService;
    private final ProductService productService;

    public PersonController(PersonService personService, ProductService productService) {
        this.personService = personService;
        this.productService = productService;
    }

    @PostMapping("/save")
    public Long save(@RequestBody PersonDto dto) {
        return personService.save(dto);
    }

    @PostMapping("/save/product")
    public Long save(@RequestBody ProductDto dto) {
        return productService.save(dto);
    }

    @GetMapping("/{id}")
    public PersonDto findById(@PathVariable Long id) {
        return personService.findById(id);
    }

    @GetMapping("/name/{name}")
    public List<PersonDto> findAllByName(@PathVariable String name) {
        return personService.findAllByName(name);
    }

    @GetMapping("/delete/{id}")
    void deleteById(@PathVariable Long id) {
        personService.deleteById(id);
    }

//    @PutMapping("/update/{id}")
//    void setAge(@RequestParam Integer age, @RequestParam Long id) {
//        personService.setAge(age, id);
//    }
//
//    @GetMapping("/status/{id}")
//    public List<Person> findByOrderStatus(@RequestParam OrderStatus orderStatus, @RequestParam Long id) {
//        return personService.findByOrderStatus(orderStatus, id);
//    }
}


