package com.idev.demo.repository;

import com.idev.demo.models.Account;
import com.idev.demo.repositories.AccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

//Allows Mongo to work
@SpringBootTest
public class AccountRepo {

    // Allows us to utilize AccountRepository
    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void test1() {
        // Save account to accountRepository
        accountRepository.save(new Account("username", "password"));
        // Check to see if the account exists by checking for that username
        assertThat(accountRepository.existsByUsername("username")).isTrue();
    }
}
