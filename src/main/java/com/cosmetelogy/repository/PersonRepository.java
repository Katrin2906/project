package com.cosmetelogy.repository;

import com.cosmetelogy.entity.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
    List<Person> findAllByIdIn(List<Long> ids);

//    @Query("select p from Person p where p.orders.orderStatus=:orderStatus")
//    List<Person> findByOrderStatus(OrderStatus orderStatus);

//    List<Person> findByOrderId(Order order);
//
////    List<Person> findAllByVisitDate(Visit visitDate);
//
//    List<Person> findAllByProcedureName(ProcedureName procedureName);
//
//    List<Person> findByNotePregnant(Note pregnant);

}
