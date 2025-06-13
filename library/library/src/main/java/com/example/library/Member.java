package com.example.library;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Member {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private LocalDate joinDate;
    private int issuedBooks;
    private boolean active;

    public Member() {}

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public LocalDate getJoinDate() { return joinDate; }
    public void setJoinDate(LocalDate joinDate) { this.joinDate = joinDate; }
    public int getIssuedBooks() { return issuedBooks; }
    public void setIssuedBooks(int issuedBooks) { this.issuedBooks = issuedBooks; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; 
    }
    public Member(UUID id, String name, LocalDate joinDate, int issuedBooks, boolean active) {
        this.id = id;
        this.name = name;
        this.joinDate = joinDate;
        this.issuedBooks = issuedBooks;
        this.active = active;
    }
}