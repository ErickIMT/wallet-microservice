package com.nttdata.wallet.infrastructure.repository;

import com.nttdata.wallet.infrastructure.entity.Customer;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

public interface CustomerRepository {

  Mono<Customer> save(Customer customer);

  Mono<Customer> findById(String id);
}
