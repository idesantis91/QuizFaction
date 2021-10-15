package com.idev.demo.controllers;

import com.idev.demo.QuizService;
import com.idev.demo.models.Account;
import com.idev.demo.repositories.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000/")
public class AuthenticationController {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    private QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<?> createAccount(@RequestBody Account account) {
        return quizService.createAccount(account);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAccount() {
        return quizService.getAccounts();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteAccount(@RequestParam(value = "username") String username) {
        return quizService.deleteAccount(username);
    }

}
