package com.idev.demo.controllers;

import com.idev.demo.models.Faction;
import com.idev.demo.repositories.AccountRepository;
import com.idev.demo.services.FactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000/")
public class FactionController {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    private FactionService factionService;

    @PostMapping("/account/{accountName}/faction/create")
    public ResponseEntity<?> createFaction(@RequestBody Faction faction, @PathVariable String accountName) {
        return factionService.createFaction(faction, accountName);
    }

    @GetMapping("/faction/list")
    public ResponseEntity<?> getFactions() {
        return factionService.getFactions();
    }

    @DeleteMapping("/faction/delete")
    public ResponseEntity<?> deleteFaction(@RequestParam(value = "factionName") String name) {
        return factionService.deleteFaction(name);
    }

}