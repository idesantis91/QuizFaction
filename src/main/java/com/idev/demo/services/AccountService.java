package com.idev.demo.services;

import java.util.List;

import com.idev.demo.models.Account;
import com.idev.demo.repositories.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    // Create Account Operation
    public ResponseEntity<?> createAccount(Account account) {
        if (accountRepository.existsByUsername(account.getUsername())) {
            System.out.println("This username is already taken.");
            return new ResponseEntity<String>("This username is already taken", HttpStatus.CONFLICT);
        } else {
            return new ResponseEntity<Account>(accountRepository.save(account), HttpStatus.CREATED);
        }

    }

    // Get Accounts
    public ResponseEntity<?> getAccounts() {
        return new ResponseEntity<List<Account>>(accountRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> deleteAccount(String username) {
        if (!accountRepository.existsByUsername(username)) {
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        } else {
            accountRepository.deleteByUsername(username);
            return new ResponseEntity<String>("Account Deleted", HttpStatus.OK);
        }
    }
}
