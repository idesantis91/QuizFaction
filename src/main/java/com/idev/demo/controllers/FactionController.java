package com.idev.demo.controllers;

import com.idev.demo.models.Faction;
import com.idev.demo.repositories.AccountRepository;
import com.idev.demo.services.AccountService;
import com.idev.demo.services.FactionService;

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
public class FactionController {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    private FactionService factionService;

    @PostMapping("/faction/create")
    public ResponseEntity<?> createFaction(@RequestBody Faction faction) {
        return factionService.createFaction(faction);
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