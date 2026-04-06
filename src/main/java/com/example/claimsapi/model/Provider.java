package com.example.claimsapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "providers")
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String npi;

    @Column(nullable = false)
    private String providerName;

    @Column(nullable = false)
    private String specialty;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNpi() { return npi; }
    public void setNpi(String npi) { this.npi = npi; }
    public String getProviderName() { return providerName; }
    public void setProviderName(String providerName) { this.providerName = providerName; }
    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }
}
