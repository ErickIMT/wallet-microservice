package com.nttdata.wallet.infrastructure.repository;

import com.nttdata.wallet.infrastructure.entity.Customer;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class RedisRepository implements CustomerRepository{

  private ReactiveRedisOperations<String, Customer> operations;

  public RedisRepository(ReactiveRedisOperations<String, Customer> operations) {
    this.operations = operations;
  }

  @Override
  public Mono<Customer> save(Customer customer) {
    return operations.opsForValue()
      .set(customer.getId(), customer)
      .map(__ -> customer);
  }

  @Override
  public Mono<Customer> findById(String id) {
    return operations.opsForValue()
      .get(id)
      .map(customer -> new Customer(
        customer.getId(),
        customer.getTypeId(),
        customer.getCellphoneNumber(),
        customer.getEmail(),
        customer.getBootcoinAmount()));
  }
}
