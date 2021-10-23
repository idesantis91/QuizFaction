package com.idev.demo.models;

import java.util.List;

public class Faction {

    // Make Random id
    private String id;
    private String factionName;
    private String description;
    private List<Account> accounts;

    public Faction() {

    }

    public Faction(String id, String factionName) {
        this.id = id;
        this.factionName = factionName;
    }

    public Faction(String id, String factionName, List<Account> accounts) {
        this.id = id;
        this.factionName = factionName;
        this.accounts = accounts;
    }

    public Faction(String id, String factionName, String description, List<Account> accounts) {
        this.id = id;
        this.factionName = factionName;
        this.description = description;
        this.accounts = accounts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFactionName() {
        return factionName;
    }

    public void setFactionName(String factionName) {
        this.factionName = factionName;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
