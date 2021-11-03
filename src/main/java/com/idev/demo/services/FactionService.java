package com.idev.demo.services;

import java.util.List;

import com.idev.demo.models.Account;
import com.idev.demo.models.Faction;
import com.idev.demo.repositories.AccountRepository;
import com.idev.demo.repositories.FactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FactionService {

    @Autowired
    private FactionRepository factionRepository;

    @Autowired
    private AccountRepository accountRepository;

    // Create Faction Operation
    public ResponseEntity<?> createFaction(Faction faction, String accountName) {
        if (factionRepository.existsByFactionName(faction.getFactionName())) {
            System.out.println("This Faction name is already taken.");
            return new ResponseEntity<String>(faction.getFactionName() + " is already taken", HttpStatus.CONFLICT);
        } else {
            if (!accountRepository.existsByUsername(accountName)) {
                return new ResponseEntity<String>(accountName + " doesn't exist.", HttpStatus.CONFLICT);
            } else {
                Account account = accountRepository.findByUsername(accountName);
                faction.addUserToFaction(account);
                System.out.println(faction);
                return new ResponseEntity<Faction>(factionRepository.save(faction), HttpStatus.CREATED);
            }
        }

    }

    // Get Accounts
    public ResponseEntity<?> getFactions() {
        return new ResponseEntity<List<Faction>>(factionRepository.findAll(), HttpStatus.OK);
    }

    // Delete a faction
    public ResponseEntity<?> deleteFaction(String name) {
        if (!factionRepository.existsByFactionName(name)) {
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        } else {
            factionRepository.deleteByFactionName(name);
            return new ResponseEntity<String>("Faction Deleted", HttpStatus.OK);
        }
    }

}
