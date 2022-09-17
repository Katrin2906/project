package com.cosmetelogy.repository;

import com.cosmetelogy.entity.Person;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.List;

public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

    List<Person> findByIdIn(List<Long> ids);

//    @Modifying
//    @Query("select p from Person p where p.orders.orderStatus=:orderStatus")
//    List<Person> findByOrderStatus(OrderStatus orderStatus);

    List<Person> findAllByName(String name);

    void deleteById(Long id);

    @Modifying
    @Query("update Person p set p.age=?1 where p.id=?2")
    void setAge(Integer age, Long id);
}
