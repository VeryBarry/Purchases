package com.theironyard;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by VeryBarry on 11/1/16.
 */
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
