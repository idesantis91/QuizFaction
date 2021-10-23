package com.idev.demo.repositories;

import com.idev.demo.models.Faction;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface FactionRepository extends MongoRepository<Faction, String> {

    boolean existsByFactionName(String factionName);

    void deleteByFactionName(String name);

}
