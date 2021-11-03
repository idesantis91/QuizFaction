package com.idev.demo.repositories;

import com.idev.demo.models.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, String> {

    boolean existsByUsername(String username);

    Account findByUsername(String username);

    void deleteByUsername(String username);

}
