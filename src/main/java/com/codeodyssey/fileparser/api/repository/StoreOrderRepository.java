package com.codeodyssey.fileparser.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codeodyssey.fileparser.api.model.StoreOrder;

/**
 * @Description Repository Interface
 * for communication between Application object and
 * database
 */
@Repository
public interface StoreOrderRepository extends CrudRepository<StoreOrder,Integer>{

}
