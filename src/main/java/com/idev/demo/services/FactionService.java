package com.idev.demo.services;

import java.util.List;

import com.idev.demo.models.Faction;
import com.idev.demo.repositories.FactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FactionService {

    @Autowired
    private FactionRepository factionRepository;

    // Create Account Operation
    public ResponseEntity<?> createFaction(Faction faction) {
        if (factionRepository.existsByFactionName(faction.getFactionName())) {
            System.out.println("This username is already taken.");
            return new ResponseEntity<String>(faction.getFactionName() + " is already taken", HttpStatus.CONFLICT);
        } else {
            return new ResponseEntity<Faction>(factionRepository.save(faction), HttpStatus.CREATED);
        }

    }

    // Get Accounts
    public ResponseEntity<?> getFactions() {
        return new ResponseEntity<List<Faction>>(factionRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> deleteFaction(String name) {
        if (!factionRepository.existsByFactionName(name)) {
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        } else {
            factionRepository.deleteByFactionName(name);
            return new ResponseEntity<String>("Faction Deleted", HttpStatus.OK);
        }
    }
}
